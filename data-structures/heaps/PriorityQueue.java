import java.util.Scanner;

public class PriorityQueue {
  int[] pq;
  int size;
  int capacity;

  public PriorityQueue(int capacity) {
    this.capacity = capacity;
    pq = new int[capacity];
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
    int t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
  }

  boolean isEmpty() {
    return size == 0;
  }

  boolean isFull() {
    return size == capacity;
  }

  void push(int value) {
    if (isFull()) {
      System.out.println("Priority Queue is full");
      return;
    }

    pq[size] = value;
    int i = size;
    size++;

    while (i > 0 && pq[i] > pq[parent(i)]) {
      swap(i, parent(i));
      i = parent(i);
    }

    System.out.println("Inserted: " + value);
  }

  int pop() {
    if (isEmpty()) {
      System.out.println("Priority Queue is empty");
      return -1;
    }

    int top = pq[0];
    pq[0] = pq[size - 1];
    size--;
    heapify(0);

    System.out.println("Removed: " + top);
    return top;
  }

  int peek() {
    if (isEmpty()) {
      System.out.println("Priority Queue is empty");
      return -1;
    }
    return pq[0];
  }

  void heapify(int i) {
    int largest = i;
    int l = left(i);
    int r = right(i);

    if (l < size && pq[l] > pq[largest])
      largest = l;
    if (r < size && pq[r] > pq[largest])
      largest = r;

    if (largest != i) {
      swap(i, largest);
      heapify(largest);
    }
  }

  void display() {
    if (isEmpty()) {
      System.out.println("Priority Queue is empty");
      return;
    }

    System.out.print("Priority Queue (heap order): ");
    for (int i = 0; i < size; i++) {
      System.out.print(pq[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PriorityQueue pq = new PriorityQueue(50);

    while (true) {
      System.out.println("\n--- Priority Queue Menu ---");
      System.out.println("1. Insert element");
      System.out.println("2. Remove highest priority element");
      System.out.println("3. Peek highest priority element");
      System.out.println("4. Display queue");
      System.out.println("5. Check if empty");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter value to insert: ");
          pq.push(sc.nextInt());
          break;

        case 2:
          pq.pop();
          break;

        case 3:
          int top = pq.peek();
          if (top != -1)
            System.out.println("Highest priority element: " + top);
          break;

        case 4:
          pq.display();
          break;

        case 5:
          System.out.println(pq.isEmpty() ? "Queue is empty" : "Queue is not empty");
          break;

        case 6:
          System.out.println("Exiting...");
          sc.close();
          return;

        default:
          System.out.println("Invalid choice");
      }
    }
  }
}
