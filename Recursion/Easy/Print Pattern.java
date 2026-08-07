class Main{
	public static void solve(int n){
        // Your code here
        if(n == 0) return;
        solve(n-1);
        for(int i=1; i<=n; i++){
            System.out.print("# ");
        }
        System.out.println();
    }
}

/* 

#
# #
# # #
# # # #
# # # # #

*/
