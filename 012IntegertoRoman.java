class Solution {
    public String intToRoman(int num) {
        String[] sin = {"I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] ten = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hun = {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thu = {"M","MM","MMM"};
        StringBuilder result = new StringBuilder("");
        int i = num / 1000;
        num = num % 1000;
        if(i > 0) result.append(thu[i-1]);
        i = num / 100;
        num = num % 100;
        if(i > 0) result.append(hun[i-1]);
        i = num / 10;
        num = num % 10;
        if(i > 0) result.append(ten[i-1]);
        i = num;
        if(i > 0) result.append(sin[i-1]);
        return result.toString();
    }
}
