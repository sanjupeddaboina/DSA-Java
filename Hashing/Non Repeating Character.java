/* Non Repeating Character:
Given a string S consisting of lowercase Latin Letters. Find the first non-repeating character in S.
*/

class Solution {
    public void nonRepeatingCharacter(String s) {
        // Your code here
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println(-1);
    }
}
