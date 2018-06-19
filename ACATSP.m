function [R_best,L_best,L_ave,Shortest_Route,Shortest_Length]=ACATSP(C,NC_max,m,Alpha,Beta,Rho,Q)
%%=========================================================================
%% ACATSP.m
%% Ant Colony Algorithm for Traveling Salesman Problem
%%-------------------------------------------------------------------------
%% 主要符号说明
%% C n个城市的坐标，n×2的矩阵
%% NC_max 最大迭代次数
%% m 蚂蚁个数
%% Alpha 表征信息素重要程度的参数
%% Beta 表征启发式因子重要程度的参数
%% Rho 信息素蒸发系数
%% Q 信息素增加强度系数
%% R_best 各代最佳路线
%% L_best 各代最佳路线的长度

%% All copyright reserved
%% Author:Zhang Hongzhi
%% Address:Hust, C9 320
%% E-mail:glandchang@gmail.com
%%=========================================================================

%%第一步：变量初始化
tic;
n=size(C,1);%n表示问题的规模（城市个数）
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
R_best=zeros(NC_max,n);%各代最佳路线，NC_max 最大迭代次数
L_best=inf.*ones(NC_max,1);%各代最佳路线的长度
L_ave=zeros(NC_max,1);%各代路线的平均长度

while NC<=NC_max%停止条件之一：达到最大迭代次数
    
    
    
    %%第二步：将m只蚂蚁放到n个城市上
    Randpos=[];
    for i=1:(ceil(m/n))%ceil是向正方向进行取整
        Randpos=[Randpos,randperm(n)]; %randperm是将1到n这些数随机打乱得到的一个数字序列
    end
    Tabu(:,1)=(Randpos(1,1:m))';%Tabu为禁忌表，每只蚂蚁都有自己的内存，用于存储该蚂蚁已经访问过的城市，表示其在以后的搜索中将不能访问这些城市；还有用另外一个允许访问的城市表（Allowed）来存储它还可以访问的城市；
    
    %%第三步：m只蚂蚁按概率函数选择下一座城市，完成各自的周游
    for j=2:n%遍历所有城市要求
        for i=1:m%所有蚂蚁进行路径选择更新
            visited=Tabu(i,1:(j-1));%对于蚂蚁i而言，已访问的城市矩阵
            J=zeros(1,(n-j+1));
            %%对于蚂蚁i而言，目前在第j-1个点，进行第j次路径选择，还有n-j+1个城市没有访问过，待访问的城市矩阵初始化
            P=J;%待访问城市的选择概率分布，由于P与J的行列数相同，所以先令两者初值相等，进行初始化
            Jc=1;%待访问城市计数变量
            
            %对于蚂蚁i而言，构建待访问城市矩阵J
            for k=1:n
                if length(find(visited==k))==0%find函数查询第k个城市是否已经访问，如果没有访问的话，进入下一步
                    J(Jc)=k;%如果第k个城市没有访问的话，在矩阵J中进行添加
                    Jc=Jc+1;
                end
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
            to_visit=J(Select(1));%前往访问的城市的序号的Select(1),编号为J(Select(1))
            Tabu(i,j)=to_visit;%更新蚂蚁i的第j次前往的城市，完成禁忌表的更新
        end
    end
    
    if NC>=2
        Tabu(1,:)=R_best(NC-1,:);
    end
    
    %%第四步：记录本次迭代最佳路线
    L=zeros(m,1);%L为m只蚂蚁的路线长度统计矩阵，为m*1阶
    for i=1:m
        R=Tabu(i,:);%R为第m只蚂蚁的路线选择方式，为1*n阶，对于每一只蚂蚁而言，其路径即为对应的禁忌表
        for j=1:(n-1)
            L(i)=L(i)+D(R(j),R(j+1));%对第i只蚂蚁的路径长度进行计算
        end
        L(i)=L(i)+D(R(1),R(n));%最后要回到原点，把最后一段距离加上去
    end
    L_best(NC)=min(L);%第NC代的最短路径长度
    pos=find(L==L_best(NC));%find函数,找到L中等于L_best的序号，即为对应的最优路径蚂蚁编号，可能有多个蚂蚁同时找到当代的最优路径
    R_best(NC,:)=Tabu(pos(1),:);%第NC代的最优路径
    [L_best(NC),R_best(NC,:)]=op_2(L_best(NC),R_best(NC,:),D,NC);%进行op_2优化
    L_ave(NC)=mean(L);%第NC代的平均路径长度
    NC=NC+1
    
    %%第五步：更新信息素
    Delta_Tau=zeros(n,n);%信息素增量矩阵，信息素是停留在路径上的，所以阶数为n*n
    %禁忌表Tabu中存储的为蚂蚁的访问城市顺序，对应的蚂蚁i的行驶路径即为Tabu(i,j)→Tabu(i,j+1)
    %方式1，每条路径均产生信息素
    for i=1:m
        for j=1:(n-1)
            Delta_Tau(Tabu(i,j),Tabu(i,j+1))=Delta_Tau(Tabu(i,j),Tabu(i,j+1))+Q/L(i);%信息素的增量计算公式为Q/L
        end
        Delta_Tau(Tabu(i,n),Tabu(i,1))=Delta_Tau(Tabu(i,n),Tabu(i,1))+Q/L(i);
    end
    Tau=(1-Rho).*Tau+Delta_Tau;%考虑信息素的增发情况
    
    %方式2，每一代最优路径才产生信息素
    %     for j=1:(n-1)
    %             Delta_Tau(R_best(NC,j),R_best(NC,j+1))=Delta_Tau(R_best(NC,j),R_best(NC,j+1))+Q/L_best(NC);%信息素的增量计算公式为Q/L
    %     end
    %         Delta_Tau(R_best(NC,n),R_best(NC,1))=Delta_Tau(R_best(NC,n),R_best(NC,1))+Q/L_best(NC);
    %     Tau=(1-Rho).*Tau+Delta_Tau;%考虑信息素的增发情况

    
    %%第六步：禁忌表清零
    Tabu=zeros(m,n);
end

%第七步：输出结果

Pos=find(L_best==min(L_best));
Shortest_Route=R_best(Pos(1),:)
Shortest_Length=L_best(Pos(1))
figure;
DrawRoute(C,Shortest_Route)
figure;
plot(L_best)
hold on
plot(L_ave)
toc;
end
