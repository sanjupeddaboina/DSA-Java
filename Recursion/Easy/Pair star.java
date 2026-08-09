/* Problem Statement: Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*". */

public class Main {
    static String PairStar(String str) {
        if(str.length() <= 1) return str;
        return putStars(str,0,"");
    }
    public static String putStars(String str, int startidx, String ans){
        if(startidx == str.length()-1){
            return ans + str.charAt(startidx);
        }
        if(str.charAt(startidx) == str.charAt(startidx+1)){
            ans = ans + str.charAt(startidx)+"*";
        }else{
            ans = ans + str.charAt(startidx);
        }
        return putStars(str,startidx + 1,ans);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(PairStar(s));
    }
}
