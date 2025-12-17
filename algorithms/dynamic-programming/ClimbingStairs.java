import java.util.Scanner;

public class ClimbingStairs {

  static int climb(int n) {
    if (n <= 2)
      return n;
    int a = 1, b = 2;
    for (int i = 3; i <= n; i++) {
      int c = a + b;
      a = b;
      b = c;
    }
    return b;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(climb(sc.nextInt()));
    sc.close();
  }
}
