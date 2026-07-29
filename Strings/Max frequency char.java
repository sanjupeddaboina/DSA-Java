public class Main {
    
     static char MaximumFrequencyChar(String s) {
        //Write your code here
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        int maxFreq = 0;
        char result = 'a';
        for(int i=0; i<freq.length; i++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
                result = (char)(i + 'a');
            }
        }
        return result;
    }
}
