public class Main {
	static void compressedString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        while(j < n){
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }else{
                sb.append(s.charAt(i));
                int freq = j-i;
                if(freq > 1){
                    sb.append(freq);
                }
                i = j;
                j++;
            }
        }
        sb.append(s.charAt(i));
        int freq = j-i;
        if(freq > 1){
            sb.append(freq);
        }
        System.out.print(sb);
    }
}
