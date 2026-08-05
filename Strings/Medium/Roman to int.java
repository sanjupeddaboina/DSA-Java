class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n = s.length();
        char c = s.charAt(n-1);
        int resultNum = map.get(c);
        for(int i = n-2; i>=0; i--){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(map.get(ch1) < map.get(ch2)){
                resultNum -= map.get(ch1);
            }else{
                resultNum += map.get(ch1);
            }
        }
        return resultNum;
    }
}
