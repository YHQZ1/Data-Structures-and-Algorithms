import java.util.Scanner;

public class DoublyLinkedList {
  Node head;
  Scanner sc = new Scanner(System.in);

  class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }

  public void insertAtBeginning(int data){
    Node newNode = new Node(data);
    if(head != null){
      head.prev = newNode;
    }
    newNode.next = head;
    head = newNode;
  }

  public void insertAtEnd(int data){
    Node newNode = new Node(data);
    if(head == null){
      head = newNode;
      return;
    }
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }

    temp.next = newNode;
    newNode.prev = temp;
  }

  public void insertAtPosition(int data, int position){
    if(position<1){
      System.out.println("Invalid position! Positions start from 1.");
      return;
    }
    Node newNode = new Node(data);
    if(position == 1){
      insertAtBeginning(data);
      return;
    }
    Node temp = head;
    for(int i=0; i<position-1 && temp != null; i++){
      temp = temp.next;
    }

    if(temp == null || temp.next == null){
      insertAtEnd(data);
      return;
    }
    newNode.next = temp.next;
    newNode.prev = temp;
    temp.next.prev = newNode;
    temp.next = newNode;
  }

  public void deleteFromBeginning(){
    if(head == null){
      System.out.println("List is empty!");
      return;
    }
    head = head.next;
    if(head != null){
      head.prev = null;
    }
  }

  public void deleteFromEnd(){
    if(head == null){
      System.out.println("List is empty!");
      return;
    }
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.prev.next = null;
  }

  public void deleteAtPosition(int position){
    if(position < 1){
      System.out.println("invalid position! Positions start from 1.");
      return;
    }
    if(position == 1){
      deleteFromBeginning();
      return;
    }

    Node temp = head;
    for(int i=0; i<position && temp != null; i++){
      temp = temp.next;
    }

    if(temp == null){
      System.out.println("position out of bounds!");
    }
    if(temp.next == null){
      deleteFromEnd();
    }
    if(temp.prev != null){
      temp.prev.next = temp.next;
    }
  }

  public boolean search(int value){
    Node temp = head;
    while(temp != null){
      if(temp.data == value){
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  public void reverse(){
    Node temp = null;
    Node current = head;
    while(current != null){
      temp = current.prev;
      current.prev = current.next;
      current.next = temp;
      current = current.prev;
    }
    if(temp != null){
      head = temp.prev;
    }
  }

  public void update(int newValue, int position){
    if(head == null || position<1){
      System.out.println("Invalid position or empty list");
      return;
    }
    Node temp = head;
    for(int i=0; i<position-1 && temp != null; i++){
      temp = temp.next;
    }
    if(temp == null){
      System.out.println("position out of bounds");
      return;
    }
    temp.data = newValue;
    System.out.println("Updated value at position " + position + " to " + newValue);
  }

  public void printList(){
    Node temp = head;
    if(head == null){
      System.out.println("the list is empty");
      return;
    }
    System.out.println("NULL <-");
    while(temp != null){
      System.out.print(temp.data + "<->");
      temp = temp.next;
    }
    System.out.print("NULL");
  }

  public void menu(){
    while(true){
      System.out.println("\n=== Doubly Linked List Operations ===");
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

      int choice = sc.nextInt();
      switch (choice) {
        case 1:
            System.out.print("Enter value to insert at beginning: ");
            insertAtBeginning(sc.nextInt());
            break;
        case 2:
            System.out.print("Enter value to insert at end: ");
            insertAtEnd(sc.nextInt());
            break;
        case 3:
            System.out.print("Enter value to insert: ");
            int data = sc.nextInt();
            System.out.print("Enter position to insert at: ");
            insertAtPosition(data, sc.nextInt());
            break;
        case 4:
            deleteFromBeginning();
            break;
        case 5:
            deleteFromEnd();
            break;
        case 6:
            System.out.print("Enter position to delete: ");
            deleteAtPosition(sc.nextInt());
            break;
        case 7:
            System.out.print("Enter value to search: ");
            System.out.println(search(sc.nextInt()) ? "Element found!" : "Element not found!");
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
            int pos = sc.nextInt();
            System.out.print("Enter new value: ");
            update(pos, sc.nextInt());
            break;
        case 11:
            System.out.println("Exiting program...");
            sc.close();
            return;
        default:
            System.out.println("Invalid choice! Please try again.");
      }
    }
  }
  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.menu();
  }
}
