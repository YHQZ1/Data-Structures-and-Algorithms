import java.util.Scanner;

public class LinkedList {
    Node head;
    Scanner scanner = new Scanner(System.in);

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
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
    }

    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position! Positions start from 1.");
            return;
        }
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteAtPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or empty list!");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        temp.next = temp.next.next;
    }

    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void reverse() {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void update(int position, int newValue) {
        if (head == null) {
            System.out.println("List is empty, nothing to update!");
            return;
        }
        if (position < 1) {
            System.out.println("Invalid position! Please enter a position starting from 1.");
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds! No update performed.");
            return;
        }
        temp.data = newValue;
        System.out.println("Successfully updated node at position " + position + " with value " + newValue);
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== Linked List Operations ===");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Specific Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Specific Position");
            System.out.println("7. Search an Element");
            System.out.println("8. Reverse Linked List");
            System.out.println("9. Display Linked List");
            System.out.println("10. Update a Node");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    insertAtBeginning(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    insertAtEnd(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    int data = scanner.nextInt();
                    System.out.print("Enter position to insert at: ");
                    insertAtPosition(data, scanner.nextInt());
                    break;
                case 4:
                    deleteFromBeginning();
                    break;
                case 5:
                    deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    deleteAtPosition(scanner.nextInt());
                    break;
                case 7:
                    System.out.print("Enter value to search: ");
                    System.out.println(search(scanner.nextInt()) ? "Element found!" : "Element not found!");
                    break;
                case 8:
                    reverse();
                    System.out.println("Linked List reversed.");
                    break;
                case 9:
                    printList();
                    break;
                case 10:
                    System.out.print("Enter position to update: ");
                    int pos = scanner.nextInt();
                    System.out.print("Enter new value: ");
                    update(pos, scanner.nextInt());
                    break;
                case 11:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.menu();
    }
}
