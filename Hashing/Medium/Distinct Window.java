/* Distinct Window:
You are given a string s.
Your task is to find the smallest window of string with all distinct characters of the given string.
*/


public class Main {

    public static String DistinctWindow(String s){
        //write code here
        int n = s.length();
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            set.add(s.charAt(i));
        }
        int minLen = Integer.MAX_VALUE;
        int i=0, j=0;
        int startIdx = -1, endIdx = -1;
        while(j < n){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(set.size() == map.size()){
                int len = j-i+1;
                if(len < minLen){
                    minLen = len;
                    startIdx = i;
                    endIdx = j;
                }
                char ch2 = s.charAt(i);
                map.put(ch2,map.get(ch2)-1);
                if(map.get(ch2) == 0){
                    map.remove(ch2);
                }
                i++;
            }
            j++;
        }
        String ss = s.substring(startIdx,endIdx+1);
        return ss;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}
