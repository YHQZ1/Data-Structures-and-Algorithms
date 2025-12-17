import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

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
    Node newNode = new Node(data);
    if (root == null) {
      root = newNode;
      return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      Node curr = q.poll();

      if (curr.left == null) {
        curr.left = newNode;
        return;
      } else {
        q.add(curr.left);
      }

      if (curr.right == null) {
        curr.right = newNode;
        return;
      } else {
        q.add(curr.right);
      }
    }
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

  public void levelOrder() {
    if (root == null)
      return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      Node curr = q.poll();
      System.out.print(curr.data + " ");
      if (curr.left != null)
        q.add(curr.left);
      if (curr.right != null)
        q.add(curr.right);
    }
    System.out.println();
  }

  public int height() {
    return heightRec(root);
  }

  private int heightRec(Node root) {
    if (root == null)
      return -1;
    return Math.max(heightRec(root.left), heightRec(root.right)) + 1;
  }

  public int countNodes() {
    return countNodesRec(root);
  }

  private int countNodesRec(Node root) {
    if (root == null)
      return 0;
    return 1 + countNodesRec(root.left) + countNodesRec(root.right);
  }

  public int countLeaves() {
    return countLeavesRec(root);
  }

  private int countLeavesRec(Node root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    return countLeavesRec(root.left) + countLeavesRec(root.right);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BinaryTree tree = new BinaryTree();
    boolean exit = false;

    while (!exit) {
      System.out.println("\n1.Insert");
      System.out.println("2.Inorder");
      System.out.println("3.Preorder");
      System.out.println("4.Postorder");
      System.out.println("5.Level Order");
      System.out.println("6.Height");
      System.out.println("7.Count Nodes");
      System.out.println("8.Count Leaves");
      System.out.println("9.Exit");

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter value: ");
          tree.insert(sc.nextInt());
          break;
        case 2:
          tree.inorder();
          break;
        case 3:
          tree.preorder();
          break;
        case 4:
          tree.postorder();
          break;
        case 5:
          tree.levelOrder();
          break;
        case 6:
          System.out.println(tree.height());
          break;
        case 7:
          System.out.println(tree.countNodes());
          break;
        case 8:
          System.out.println(tree.countLeaves());
          break;
        case 9:
          exit = true;
          break;
        default:
          System.out.println("Invalid choice");
      }
    }
    sc.close();
  }
}
