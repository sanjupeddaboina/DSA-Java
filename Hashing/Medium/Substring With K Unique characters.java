/* Substring With K Unique characters
You are given a string 's'.
You need to print length of longest possible substring that has exactly k unique characters. If there is no such string print -1.
*/


import java.util.*;

public class Main {

    public static int longestkSubstr(int n, int k,String s){
        //write code here
        Map<Character,Integer> map = new HashMap<>();
        int i=0, j=0;
        int maxLen = -1;
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size() == k){
                int len = j-i+1;
                maxLen = Math.max(maxLen,len);
            }
            while(map.size() > k){
                char ch2 = s.charAt(i);
                map.put(ch2,map.get(ch2)-1);
                if(map.get(ch2) == 0){
                    map.remove(ch2);
                }
                i++;
            }
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = longestkSubstr(n,k,s);
        System.out.println(ans);
    }
}
