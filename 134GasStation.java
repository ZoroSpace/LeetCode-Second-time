class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curOil = 0;
        int minIndex = 0;
        int minOil = gas[0]-cost[0];
        for(int i = 0;i < gas.length;i++) {
            curOil += gas[i]-cost[i];
            if(curOil < minOil) {
                minOil = curOil;
                minIndex = i;
            }
        }
        if(curOil < 0) return -1;
        return (minIndex+1)%gas.length;
    }
}
