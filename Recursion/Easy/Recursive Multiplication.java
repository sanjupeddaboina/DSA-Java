public class Main {
  public static int multiplyRecursively(int n, int m) {
    if(m == 0) return 0;
    if(m < 0) return multiplyRecursively(n,-m);
    return n + multiplyRecursively(n,m-1);
  }
}
