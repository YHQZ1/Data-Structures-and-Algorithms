import java.util.Scanner;

public class HouseRobber {

  static int rob(int[] nums) {
    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];

    int prev2 = nums[0];
    int prev1 = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      int curr = Math.max(prev1, prev2 + nums[i]);
      prev2 = prev1;
      prev1 = curr;
    }
    return prev1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    System.out.println(rob(arr));
    sc.close();
  }
}
