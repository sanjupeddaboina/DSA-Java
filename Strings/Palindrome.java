public class Main {
	static int isPalindrome(String str){
    
        int n = str.length();
        StringBuilder sb = new StringBuilder();
    
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                char chLower =(char) (ch-'A'+'a');
                sb.append(chLower);
            }else if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }
        }
        int i=0, j=sb.length()-1;
        while(i <= j){
            if(sb.charAt(i) != sb.charAt(j)){
                return 0;
            }
            i++;
            j--;
        }
        return 1;
    }
