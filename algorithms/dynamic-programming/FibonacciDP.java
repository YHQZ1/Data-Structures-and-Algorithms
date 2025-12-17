import java.util.Arrays;
import java.util.Scanner;

public class FibonacciDP {

  static int fibMemo(int n, int[] dp) {
    if (n <= 1)
      return n;
    if (dp[n] != -1)
      return dp[n];
    return dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
  }

  static int fibTab(int n) {
    if (n <= 1)
      return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 2];
    return dp[n];
  }

  static int fibOptimized(int n) {
    if (n <= 1)
      return n;
    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
      int c = a + b;
      a = b;
      b = c;
    }
    return b;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);

    System.out.println("Memoization: " + fibMemo(n, dp));
    System.out.println("Tabulation: " + fibTab(n));
    System.out.println("Space Optimized: " + fibOptimized(n));

    sc.close();
  }
}
