import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

  static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i)
          dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] coins = new int[n];
    for (int i = 0; i < n; i++)
      coins[i] = sc.nextInt();
    int amount = sc.nextInt();

    System.out.println(coinChange(coins, amount));
    sc.close();
  }
}
