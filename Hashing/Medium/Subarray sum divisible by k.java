public class Main {

    public static int subarrayDivisbleByK(int arr[], int n, int k){
       int count = 0;
       int sum = 0;
       int[] map = new int[k];
       map[0] = 1;
        for(int num : arr){
            sum += num;
            int rem = ((sum%k)+k)%k;
            count = count + map[rem];
            map[rem]++;
        }
       return count;
    }
}
