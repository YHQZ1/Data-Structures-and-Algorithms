import java.util.Arrays;
import java.util.Scanner;

public class JobSequencing {

  static class Job {
    int id, deadline, profit;

    Job(int id, int d, int p) {
      this.id = id;
      deadline = d;
      profit = p;
    }
  }

  static int maxProfit(Job[] jobs) {
    Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

    int maxDeadline = 0;
    for (Job j : jobs)
      maxDeadline = Math.max(maxDeadline, j.deadline);

    boolean[] slot = new boolean[maxDeadline + 1];
    int profit = 0;

    for (Job job : jobs) {
      for (int t = job.deadline; t > 0; t--) {
        if (!slot[t]) {
          slot[t] = true;
          profit += job.profit;
          break;
        }
      }
    }
    return profit;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Job[] jobs = new Job[n];
    for (int i = 0; i < n; i++)
      jobs[i] = new Job(i, sc.nextInt(), sc.nextInt());

    System.out.println(maxProfit(jobs));
    sc.close();
  }
}
