function [L_best,L_ave,Shortest_Route,Shortest_Length]=ACAMTSP(Cha,NC_max,load_cons,m,Alpha,Beta,Rho,Q)
%% =========================================================================
%% ACAMTSP.m
%% Ant Colony Algorithm for Multiple Traveling Salesman Problem
%% -------------------------------------------------------------------------
%% 主要符号说明
%% Cha n个城市的信息矩阵，n×3的矩阵，前两列为城市坐标，后一列为n个城市的载重需求
%% NC_max 最大迭代次数
%% load_cons 车辆载重约束条件
%% m 蚂蚁个数
%% Alpha 表征信息素重要程度的参数
%% Beta 表征启发式因子重要程度的参数
%% Rho 信息素蒸发系数
%% Q 信息素增加强度系数
%% L_best 各代最佳路线的长度

%% All copyright reserved
%% Author:Zhang Hongzhi
%% Address:Hust, C9 320
%% E-mail:glandchang@gmail.com
%%=========================================================================
tic;
%%第一步：变量初始化
n=size(Cha,1);%n表示问题的规模（城市个数）
C=Cha(:,1:2);%提取城市的坐标矩阵
load=Cha(:,3);%提取城市的货物需求矩阵
D=zeros(n,n);%D表示完全图的赋权邻接矩阵
for i=1:n
    for j=1:n
        if i~=j
            D(i,j)=((C(i,1)-C(j,1))^2+(C(i,2)-C(j,2))^2)^0.5;
        else
            D(i,j)=eps;
        end
        D(j,i)=D(i,j);
    end
end
Eta=1./D;%Eta为启发因子，这里设为距离的倒数
Tau=ones(n,n);%Tau为信息素矩阵
Tabu=zeros(m,n);%存储并记录路径的生成
NC=1;%迭代计数器
L_best=inf.*ones(NC_max,1);%各代最佳路线的长度
L_ave=zeros(NC_max,1);%各代路线的平均长度
R=[];%群落路线选择中间变量
Shortest_Route_NC=[];%第NC代最优路径
Tau_max=1; %信息素最大值初始化
Tau_min=Tau_max*0.05; %信息素最小值
Tabu_best=zeros(NC,n);%每一代最优路径对应的禁忌表

while NC<=NC_max%停止条件之一：达到最大迭代次数
    
    fprintf('开始第%d次搜索 , 剩余%d次\n',NC,NC_max-NC);
    
    if(NC==1)
        L_best_temp_NC=inf;%第NC代的最优路径
    else
        L_best_temp_NC=L_best(NC-1);%第NC代的最优路径
    end
    
    %%第二步：进行每个蚂蚁群落的路径更新
    Randpos=[];
    L=zeros(m,1);%L为m个蚂蚁群落的路线长度统计矩阵，为m*1阶
    rand_mat=[2:n];
    
    for i=1:(ceil(m/(n-1)))%ceil是向正方向进行取整
        rand_mat=rand_mat(randperm(numel(rand_mat)));
        Randpos=[Randpos,rand_mat]; %randperm是将1到n这些数随机打乱得到的一个数字序列
    end
    Tabu(:,1)=1;%1号节点均为出发点
    Tabu(:,2)=(Randpos(1,1:m))';%Tabu为禁忌表，每只蚂蚁都有自己的内存，用于存储该蚂蚁已经访问过的城市，表示其在以后的搜索中将不能访问这些城市；还有用另外一个允许访问的城市表（Allowed）来存储它还可以访问的城市
    num_com=1;%群落中蚂蚁数目计数器
    
    
    %%第三步：m只蚂蚁群按概率函数选择下一座城市，完成各自的周游
    sumload=0;%初始化载重统计
    
    for i=1:m%所有蚂蚁群落进行路径选择更新
        community_path=[Tabu(i,1),Tabu(i,2)];
        sumload=load(Tabu(i,1))+load(Tabu(i,2));%初始化载重统计
        Jc=1;%待访问城市计数变量
        %初始化J矩阵
        J=setdiff([1:n],community_path);
        P=J;%待访问城市的选择概率分布，由于P与J的行列数相同，所以先令两者初值相等，进行初始化
        
        for j=3:n%遍历所有城市要求
            visited=Tabu(i,1:(j-1));%对于蚂蚁群落i而言，已访问的城市矩阵
            %%对于群落i而言，目前在第j-1个点，进行第j次路径选择，还有n-j+1个城市没有访问过，待访问的城市矩阵初始化
            
            Jc=1;%待访问城市计数变量
            
            J=[];
            %对于蚂蚁i而言，构建待访问城市矩阵J
            for k=1:n
                if length(find(visited==k))==0%find函数查询第k个城市是否已经访问，如果没有访问的话，进入下一步
                    if (sumload+load(k)<=load_cons)%同时如果访问下一个城市之后的载重能够满足要求，则可以进行访问
                        J(Jc)=k;%如果第k个城市没有访问的话，在矩阵J中进行添加
                        Jc=Jc+1;
                    end
                end
            end
            P=J;
            
            if length(J)==0 %如果车辆载重超过了要求，则跳出循环，进入下一个蚂蚁
                community_path=[community_path,1];%采用新蚂蚁，群落路径更新起点
                num_com=num_com+1;
                sumload=0;
                %重新获得待前往的城市
                [P,J]=get_J(visited,sumload,load,load_cons,n);
            end
            
            
            %下面计算待选城市的概率分布，公式中Tau为信息素矩阵；Eta为启发因子，其数值为距离的倒数
            for k=1:length(J)
                %visited(end)为蚂蚁i当前所在的城市的编号；visited矩阵根据禁忌表Tabu获得
                P(k)=(Tau(visited(end),J(k))^Alpha)*(Eta(visited(end),J(k))^Beta);
            end
            P=P/(sum(P));%进行归一化求解，得到相应的概率；
            
            %按概率原则选取下一个城市（轮盘赌原则确定）
            Pcum=cumsum(P);%cumsum函数对向量进行求和时，得到的结果也为向量
            Select=find(Pcum>=rand);%轮盘中随机选取一个角度rand，旋转rand后第一个到达的区间的坐标即为下一个访问的城市，P越大，前去访问的概率越大
            to_visit=J(Select(1));%前往访问的城市的序号为Select(1),编号为J(Select(1))
            Tabu(i,j)=to_visit;%更新蚂蚁i的第j次前往的城市，完成禁忌表的更新
            community_path=[community_path,Tabu(i,j)];%完成该蚂蚁群落的路径更新
            sumload=sumload+load(to_visit);%更新车辆的载重情况
            
            
            if (j==n)
                R=community_path;%R为第m个群落的路线选择方式
                count_R=length(R);
                for j=1:(count_R-1)
                    L(i)=L(i)+D(R(j),R(j+1));%对第i只蚂蚁群落的路径长度进行计算
                end
                L(i)=L(i)+D(R(1),R(count_R));%最后要回到原点，把最后一段距离加上去
                %将NC-1代的最优路径作为第NC代的第一个可选路径
                if(i==1)&&(NC>=2)
                    L(i)=L_best(NC-1);
                    Tabu(1,:)=Tabu_best(NC-1,:);
                end
                
                Tabu_best(NC,:)=Tabu(1,:);%初始化第NC代最优路径对应的禁忌表
                %%更新最优路径，最优路径只保存一个行向量，不保存中间优化的路径过程
                if (L(i)<L_best_temp_NC)
                    L_best_temp_NC=L(i);
                    Shortest_Route_NC=R;
                    Tabu_best(NC,:)=Tabu(i,:);
                end
                
            end
        end
    end
    
    
    
    %%第四步：记录本次迭代最佳路线
    L_best(NC)=min(L);%第NC代的最短路径长度
    L_ave(NC)=mean(L);%第NC代的平均路径长度
    %更新最优路径，最优路径只保存一个行向量，不保存中间优化的路径过程
    Shortest_Route=Shortest_Route_NC;

    
    
    
    %%第五步：更新信息素，只有NC代全局最优蚂蚁才释放信息素
    Delta_Tau=zeros(n,n);%信息素增量矩阵，信息素是停留在路径上的，所以阶数为n*n
    %最优路径中存储的为蚂蚁的访问城市顺序，对应的蚂蚁i的行驶路径即为R_best(NC,j)→R_best(NC,j+1)
    temp_len=length(Shortest_Route_NC);
    for j=1:(temp_len-1)
        Delta_Tau(Shortest_Route_NC(j),Shortest_Route_NC(j+1))=Delta_Tau(Shortest_Route_NC(j),Shortest_Route_NC(j+1))+Q/L_best(NC);%信息素的增量计算公式为Q/L
    end
    Delta_Tau(Shortest_Route_NC(temp_len),1)=Delta_Tau(Shortest_Route_NC(temp_len),1)+Q/L_best(NC);
    
    
    Tau=(1-Rho).*Tau+Delta_Tau;%考虑信息素的蒸发情况
    
    %更新完成信息素矩阵后进行边界检查
    Tau_max=NC/L_best(NC)+1/(2*(1-Rho)*L_best(NC)); %信息素最大值
    Tau_min=Tau_max*0.05; %信息素最小值
    for i=1:n
        for j=1:n
            if (Tau(i,j)>Tau_max)
                Tau(i,j)=Tau_max;
            end
            if (Tau(i,j)<Tau_min)
                Tau(i,j)=Tau_min;
            end
        end
    end
    
    
    %%第六步：禁忌表清零
    Tabu=zeros(m,n);
    NC=NC+1;
end

%%第七步：输出结果
Pos=find(L_best==min(L_best));
Shortest_Length=L_best(Pos(1));
DrawRoute(C,Shortest_Route);
figure;
plot(L_best);%历代最优解
hold on
plot(L_ave);%历代平均解
t=toc;
end
