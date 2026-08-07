public class Main {
// funcation to return fibonacci number
	public static int fib(int n ){
        if(n == 1) return 0;
        if(n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }
}
