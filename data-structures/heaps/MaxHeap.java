import java.util.Scanner;

public class MaxHeap {
  int[] heap;
  int size;

  public MaxHeap(int capacity) {
    heap = new int[capacity];
    size = 0;
  }

  int parent(int i) {
    return (i - 1) / 2;
  }

  int left(int i) {
    return 2 * i + 1;
  }

  int right(int i) {
    return 2 * i + 2;
  }

  void swap(int i, int j) {
    int t = heap[i];
    heap[i] = heap[j];
    heap[j] = t;
  }

  void insert(int val) {
    heap[size] = val;
    int i = size++;
    while (i > 0 && heap[i] > heap[parent(i)]) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

  int extractMax() {
    if (size == 0)
      return -1;
    int root = heap[0];
    heap[0] = heap[--size];
    heapify(0);
    return root;
  }

  void heapify(int i) {
    int largest = i;
    int l = left(i), r = right(i);
    if (l < size && heap[l] > heap[largest])
      largest = l;
    if (r < size && heap[r] > heap[largest])
      largest = r;
    if (largest != i) {
      swap(i, largest);
      heapify(largest);
    }
  }

  void display() {
    for (int i = 0; i < size; i++)
      System.out.print(heap[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MaxHeap h = new MaxHeap(50);

    while (true) {
      System.out.println("\n1.Insert 2.ExtractMax 3.Display 4.Exit");
      int ch = sc.nextInt();
      if (ch == 1)
        h.insert(sc.nextInt());
      else if (ch == 2)
        System.out.println(h.extractMax());
      else if (ch == 3)
        h.display();
      else
        break;
    }
    sc.close();
  }
}
