// approach1: Using XOR (optimal)
class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length+1;
        int xor1 = 0, xor2 = 0;
        for(int i=0; i<n-1; i++){
            xor1 ^= arr[i];
        }
        for(int i=0; i<=n; i++){
            xor2 ^= i;
        }
        return xor1 ^ xor2;
    }
}

//approach2: Using Sum of natural numbers (But for larger cases we use apporach1)
public class GfG {
   public static int missingNum(int[] arr) {
        long n = arr.length + 1;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        long totalSum = n * (n + 1) / 2;
        return (int)(toalSum - sum);
    }
}






