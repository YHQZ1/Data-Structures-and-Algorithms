import java.util.Scanner;

public class Queue {
	Node front = null;
	Node rear = null;
	Scanner sc = new Scanner(System.in);

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void enqueue(int data) {
		Node newNode = new Node(data);
		if (rear == null) {
			front = rear = newNode;
			return;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		System.out.println(data + " enqueued to queue.");
	}

	public void dequeue() {
		if (front == null) {
			System.out.println("Queue is empty. Cannot dequeue.");
			return;
		}
		System.out.println(front.data + " dequeued from queue.");
		front = front.next;
		if (front == null) {
			rear = null;
		}
	}

	public void peek() {
		if (front == null) {
			System.out.println("Queue is empty. Nothing to peek.");
			return;
		}
		System.out.println("Front element is: " + front.data);
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		int count = 0;
		Node temp = front;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public void display() {
		if (front == null) {
			System.out.println("Queue is empty.");
			return;
		}
		Node temp = front;
		System.out.print("Queue: ");
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
	}

	public void menu() {
		while (true) {
			System.out.println("\n=== Queue Operations ===");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Peek");
			System.out.println("4. Display");
			System.out.println("5. Check if Empty");
			System.out.println("6. Size");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter value to enqueue: ");
					enqueue(sc.nextInt());
					break;
				case 2:
					dequeue();
					break;
				case 3:
					peek();
					break;
				case 4:
					display();
					break;
				case 5:
					System.out.println(isEmpty() ? "Queue is empty." : "Queue is not empty.");
					break;
				case 6:
					System.out.println("Queue size: " + size());
					break;
				case 7:
					System.out.println("Exiting program...");
					sc.close();
					return;
				default:
					System.out.println("Invalid choice! Try again.");
			}
		}
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.menu();
	}
}
