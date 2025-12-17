import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

  static class Item {
    int weight, value;
    double ratio;

    Item(int w, int v) {
      weight = w;
      value = v;
      ratio = (double) v / w;
    }
  }

  static double knapsack(Item[] items, int capacity) {
    Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

    double totalValue = 0.0;

    for (Item item : items) {
      if (capacity == 0)
        break;

      if (item.weight <= capacity) {
        totalValue += item.value;
        capacity -= item.weight;
      } else {
        totalValue += item.ratio * capacity;
        capacity = 0;
      }
    }
    return totalValue;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Item[] items = new Item[n];
    for (int i = 0; i < n; i++)
      items[i] = new Item(sc.nextInt(), sc.nextInt());

    int capacity = sc.nextInt();
    System.out.println(knapsack(items, capacity));
    sc.close();
  }
}
