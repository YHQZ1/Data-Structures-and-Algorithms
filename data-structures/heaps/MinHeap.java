import java.util.Scanner;

public class MinHeap {
  int[] heap;
  int size;

  public MinHeap(int capacity) {
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
    while (i > 0 && heap[i] < heap[parent(i)]) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

  int extractMin() {
    if (size == 0)
      return -1;
    int root = heap[0];
    heap[0] = heap[--size];
    heapify(0);
    return root;
  }

  void heapify(int i) {
    int smallest = i;
    int l = left(i), r = right(i);
    if (l < size && heap[l] < heap[smallest])
      smallest = l;
    if (r < size && heap[r] < heap[smallest])
      smallest = r;
    if (smallest != i) {
      swap(i, smallest);
      heapify(smallest);
    }
  }

  void display() {
    for (int i = 0; i < size; i++)
      System.out.print(heap[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MinHeap h = new MinHeap(50);

    while (true) {
      System.out.println("\n1.Insert 2.ExtractMin 3.Display 4.Exit");
      int ch = sc.nextInt();
      if (ch == 1)
        h.insert(sc.nextInt());
      else if (ch == 2)
        System.out.println(h.extractMin());
      else if (ch == 3)
        h.display();
      else
        break;
    }
    sc.close();
  }
}
