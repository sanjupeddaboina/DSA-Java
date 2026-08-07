public class Solution{
  public static int findMin(int[] arr, int idx) {
        //Write your code here
        if(idx == arr.length-1){
            return arr[idx];
        }
        int num = findMin(arr,idx+1);
        return Math.min(arr[idx],num);
    }
}
