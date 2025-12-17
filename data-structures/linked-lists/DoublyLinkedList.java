import java.util.Scanner;

public class DoublyLinkedList {
	Node head;
	Scanner sc = new Scanner(System.in);

	class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		if (head != null) {
			head.prev = newNode;
			newNode.next = head;
		}
		head = newNode;
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.prev = temp;
	}

	public void insertAtPosition(int data, int position) {
		if (position < 1) {
			System.out.println("Invalid position");
			return;
		}
		if (position == 1) {
			insertAtBeginning(data);
			return;
		}
		Node temp = head;
		for (int i = 1; i < position - 1 && temp != null; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Position out of bounds");
			return;
		}
		if (temp.next == null) {
			insertAtEnd(data);
			return;
		}
		Node newNode = new Node(data);
		newNode.next = temp.next;
		newNode.prev = temp;
		temp.next.prev = newNode;
		temp.next = newNode;
	}

	public void deleteFromBeginning() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		head = head.next;
		if (head != null) {
			head.prev = null;
		}
	}

	public void deleteFromEnd() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (head.next == null) {
			head = null;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.prev.next = null;
	}

	public void deleteAtPosition(int position) {
		if (position < 1 || head == null) {
			System.out.println("Invalid position or empty list");
			return;
		}
		if (position == 1) {
			deleteFromBeginning();
			return;
		}
		Node temp = head;
		for (int i = 1; i < position && temp != null; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Position out of bounds");
			return;
		}
		if (temp.next == null) {
			deleteFromEnd();
			return;
		}
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
	}

	public boolean search(int value) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == value)
				return true;
			temp = temp.next;
		}
		return false;
	}

	public void reverse() {
		Node current = head;
		Node temp = null;
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if (temp != null) {
			head = temp.prev;
		}
	}

	public void update(int position, int newValue) {
		if (position < 1 || head == null) {
			System.out.println("Invalid position or empty list");
			return;
		}
		Node temp = head;
		for (int i = 1; i < position && temp != null; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Position out of bounds");
			return;
		}
		temp.data = newValue;
		System.out.println("Updated successfully");
	}

	public void printList() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.print("NULL <- ");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " <-> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}

	public void menu() {
		while (true) {
			System.out.println("\n1.Insert Begin  2.Insert End  3.Insert Pos");
			System.out.println("4.Delete Begin  5.Delete End  6.Delete Pos");
			System.out.println("7.Search  8.Reverse  9.Display  10.Update  11.Exit");
			int choice = sc.nextInt();
			switch (choice) {
				case 1 -> insertAtBeginning(sc.nextInt());
				case 2 -> insertAtEnd(sc.nextInt());
				case 3 -> insertAtPosition(sc.nextInt(), sc.nextInt());
				case 4 -> deleteFromBeginning();
				case 5 -> deleteFromEnd();
				case 6 -> deleteAtPosition(sc.nextInt());
				case 7 -> System.out.println(search(sc.nextInt()));
				case 8 -> reverse();
				case 9 -> printList();
				case 10 -> update(sc.nextInt(), sc.nextInt());
				case 11 -> {
					sc.close();
					return;
				}
				default -> System.out.println("Invalid choice");
			}
		}
	}

	public static void main(String[] args) {
		new DoublyLinkedList().menu();
	}
}
