class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        generateCombinations(digits,map,0,sb,result);
        return result;
    }
    public static void generateCombinations(String digits,String[] map,int i,StringBuilder curString,List<String> result){
        if(i == digits.length()){
            result.add(curString.toString());
            return;
        }
        int digit = digits.charAt(i) - '0';
        String str = map[digit];
        for(int j=0; j<str.length(); j++){
            curString.append(str.charAt(j));
            generateCombinations(digits,map,i+1,curString,result);
            curString.deleteCharAt(curString.length()-1);
        }
    }
}
}
