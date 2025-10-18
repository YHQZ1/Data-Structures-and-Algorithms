import java.util.Scanner;

public class Stack {
	Node top = null;
	Scanner sc = new Scanner(System.in);

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		System.out.println(data + " pushed to stack.");
	}

	public void pop() {
		if (top == null) {
			System.out.println("Stack is empty. Cannot pop.");
			return;
		}
		System.out.println(top.data + " popped from stack.");
		top = top.next;
	}

	public void peek() {
		if (top == null) {
			System.out.println("Stack is empty. Nothing to peek.");
			return;
		} else {
			System.out.println("Top element is: " + top.data);
		}
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		int count = 0;
		Node temp = top;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public void display() {
		if (top == null) {
			System.out.println("Stack is empty.");
			return;
		}

		Node temp = top;
		System.out.print("Stack: ");
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
	}

	public void menu() {
		while (true) {
			System.out.println("\n=== Stack Operations ===");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Display");
			System.out.println("5. Check if Empty");
			System.out.println("6. Size");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter value to push: ");
					push(sc.nextInt());
					break;
				case 2:
					pop();
					break;
				case 3:
					peek();
					break;
				case 4:
					display();
					break;
				case 5:
					System.out.println(isEmpty() ? "Stack is empty." : "Stack is not empty.");
					break;
				case 6:
					System.out.println("Stack size: " + size());
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
		Stack stack = new Stack();
		stack.menu();
	}
}
