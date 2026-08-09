class Solution {
    public int ClimbingStairs(int n) {
        // Write your code here
        if(n < 0) return 0;
        if(n == 0) return 1;
        int x = ClimbingStairs(n-1);
        int y = ClimbingStairs(n-2);
        return x + y;                           // Output : 8 -> There are 8 ways to reach stair 0 from stair n
    }
    public static void main(String[] args) {
        System.out.println(ClimbingStairs(n));  // n = 5
    }
}
