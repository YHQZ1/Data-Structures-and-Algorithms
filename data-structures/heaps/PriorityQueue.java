import java.util.Scanner;

public class PriorityQueue {
  int[] pq;
  int size;

  public PriorityQueue(int cap) {
    pq = new int[cap];
    size = 0;
  }

  int parent(int i) {
    return (i - 1) / 2;
  }

  void swap(int i, int j) {
    int t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
  }

  void push(int val) {
    pq[size] = val;
    int i = size++;
    while (i > 0 && pq[i] > pq[parent(i)]) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

  int pop() {
    if (size == 0)
      return -1;
    int top = pq[0];
    pq[0] = pq[--size];
    heapify(0);
    return top;
  }

  void heapify(int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < size && pq[l] > pq[largest])
      largest = l;
    if (r < size && pq[r] > pq[largest])
      largest = r;

    if (largest != i) {
      swap(i, largest);
      heapify(largest);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PriorityQueue pq = new PriorityQueue(50);

    while (true) {
      System.out.println("\n1.Push 2.Pop 3.Exit");
      int ch = sc.nextInt();
      if (ch == 1)
        pq.push(sc.nextInt());
      else if (ch == 2)
        System.out.println(pq.pop());
      else
        break;
    }
    sc.close();
  }
}
