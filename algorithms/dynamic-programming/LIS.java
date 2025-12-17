import java.util.Scanner;

public class LIS {

  static int lis(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    int max = 1;

    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i])
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    System.out.println(lis(arr));
    sc.close();
  }
}
