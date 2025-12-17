import java.util.Scanner;

public class BinarySearchTree {

  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  Node root;

  public void insert(int data) {
    root = insertRec(root, data);
  }

  private Node insertRec(Node root, int data) {
    if (root == null)
      return new Node(data);
    if (data < root.data)
      root.left = insertRec(root.left, data);
    else if (data > root.data)
      root.right = insertRec(root.right, data);
    return root;
  }

  public boolean search(int data) {
    return searchRec(root, data);
  }

  private boolean searchRec(Node root, int data) {
    if (root == null)
      return false;
    if (root.data == data)
      return true;
    return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
  }

  public void delete(int data) {
    root = deleteRec(root, data);
  }

  private Node deleteRec(Node root, int data) {
    if (root == null)
      return null;

    if (data < root.data) {
      root.left = deleteRec(root.left, data);
    } else if (data > root.data) {
      root.right = deleteRec(root.right, data);
    } else {
      if (root.left == null)
        return root.right;
      if (root.right == null)
        return root.left;

      int minValue = minValue(root.right);
      root.data = minValue;
      root.right = deleteRec(root.right, minValue);
    }
    return root;
  }

  private int minValue(Node root) {
    int min = root.data;
    while (root.left != null) {
      min = root.left.data;
      root = root.left;
    }
    return min;
  }

  public int min() {
    if (root == null)
      return -1;
    Node temp = root;
    while (temp.left != null)
      temp = temp.left;
    return temp.data;
  }

  public int max() {
    if (root == null)
      return -1;
    Node temp = root;
    while (temp.right != null)
      temp = temp.right;
    return temp.data;
  }

  public int height() {
    return heightRec(root);
  }

  private int heightRec(Node root) {
    if (root == null)
      return -1;
    return Math.max(heightRec(root.left), heightRec(root.right)) + 1;
  }

  public void inorder() {
    inorderRec(root);
    System.out.println();
  }

  private void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.data + " ");
      inorderRec(root.right);
    }
  }

  public void preorder() {
    preorderRec(root);
    System.out.println();
  }

  private void preorderRec(Node root) {
    if (root != null) {
      System.out.print(root.data + " ");
      preorderRec(root.left);
      preorderRec(root.right);
    }
  }

  public void postorder() {
    postorderRec(root);
    System.out.println();
  }

  private void postorderRec(Node root) {
    if (root != null) {
      postorderRec(root.left);
      postorderRec(root.right);
      System.out.print(root.data + " ");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BinarySearchTree tree = new BinarySearchTree();
    boolean exit = false;

    while (!exit) {
      System.out.println("\n1.Insert  2.Delete  3.Search");
      System.out.println("4.Inorder  5.Preorder  6.Postorder");
      System.out.println("7.Min  8.Max  9.Height  10.Exit");

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter value: ");
          tree.insert(sc.nextInt());
          break;

        case 2:
          System.out.print("Enter value: ");
          tree.delete(sc.nextInt());
          break;

        case 3:
          System.out.print("Enter value: ");
          System.out.println(tree.search(sc.nextInt()));
          break;

        case 4:
          tree.inorder();
          break;

        case 5:
          tree.preorder();
          break;

        case 6:
          tree.postorder();
          break;

        case 7:
          System.out.println(tree.min());
          break;

        case 8:
          System.out.println(tree.max());
          break;

        case 9:
          System.out.println(tree.height());
          break;

        case 10:
          exit = true;
          break;

        default:
          System.out.println("Invalid choice");
      }
    }
    sc.close();
  }
}
