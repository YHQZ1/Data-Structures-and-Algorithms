import java.util.Scanner;

public class Deque {

  class Node {
    int data;
    Node prev, next;

    Node(int data) {
      this.data = data;
    }
  }

  Node front, rear;

  void insertFront(int val) {
    Node n = new Node(val);
    if (front == null) {
      front = rear = n;
    } else {
      n.next = front;
      front.prev = n;
      front = n;
    }
    System.out.println("Inserted at front: " + val);
  }

  void insertRear(int val) {
    Node n = new Node(val);
    if (rear == null) {
      front = rear = n;
    } else {
      rear.next = n;
      n.prev = rear;
      rear = n;
    }
    System.out.println("Inserted at rear: " + val);
  }

  void deleteFront() {
    if (front == null) {
      System.out.println("Deque is empty");
      return;
    }
    System.out.println("Removed from front: " + front.data);
    front = front.next;
    if (front != null)
      front.prev = null;
    else
      rear = null;
  }

  void deleteRear() {
    if (rear == null) {
      System.out.println("Deque is empty");
      return;
    }
    System.out.println("Removed from rear: " + rear.data);
    rear = rear.prev;
    if (rear != null)
      rear.next = null;
    else
      front = null;
  }

  void display() {
    if (front == null) {
      System.out.println("Deque is empty");
      return;
    }
    Node temp = front;
    System.out.print("Deque: ");
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Deque dq = new Deque();

    while (true) {
      System.out.println("\n1.InsertFront 2.InsertRear 3.DeleteFront 4.DeleteRear 5.Display 6.Exit");
      int ch = sc.nextInt();

      switch (ch) {
        case 1 -> dq.insertFront(sc.nextInt());
        case 2 -> dq.insertRear(sc.nextInt());
        case 3 -> dq.deleteFront();
        case 4 -> dq.deleteRear();
        case 5 -> dq.display();
        default -> {
          sc.close();
          return;
        }
      }
    }
  }
}
