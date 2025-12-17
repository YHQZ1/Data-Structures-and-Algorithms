import java.util.Arrays;
import java.util.Scanner;

public class ActivitySelection {

  static class Activity {
    int start, end;

    Activity(int s, int e) {
      start = s;
      end = e;
    }
  }

  static int selectActivities(Activity[] acts) {
    Arrays.sort(acts, (a, b) -> a.end - b.end);

    int count = 1;
    int lastEnd = acts[0].end;

    for (int i = 1; i < acts.length; i++) {
      if (acts[i].start >= lastEnd) {
        count++;
        lastEnd = acts[i].end;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Activity[] acts = new Activity[n];
    for (int i = 0; i < n; i++)
      acts[i] = new Activity(sc.nextInt(), sc.nextInt());

    System.out.println(selectActivities(acts));
    sc.close();
  }
}
