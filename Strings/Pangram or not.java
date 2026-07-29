public class Main {
     public static void isPangram(String s){
          // Your code here
          int n = s.length();
          boolean[] letters = new boolean[26];
          StringBuilder res = new StringBuilder("");
          for(int i=0; i<n; i++){
               char c = s.charAt(i);
               if(c >= 'a' && c <= 'z'){
                    res.append(c);
               }else if(c >='A' && c <= 'Z'){
                    res.append((char)(c-'A'+'a'));
               }
          }
          int len = res.length();
          for(int i=0; i<len; i++){
               char ch = res.charAt(i);
               if(ch >= 'a' && ch <= 'z'){
                    letters[ch-'a'] = true;
               }
          }
          for(boolean b : letters){
               if(b == false){
                    System.out.println("not pangram");
                    return;
               }
          }
          System.out.println("pangram");
    }
}
