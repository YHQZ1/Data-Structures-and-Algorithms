import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeBFS {

  static class Node {
    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
    }
  }

  static Node buildTree(Scanner sc) {
    int val = sc.nextInt();
    if (val == -1)
      return null;

    Node root = new Node(val);
    root.left = buildTree(sc);
    root.right = buildTree(sc);
    return root;
  }

  static void bfs(Node root) {
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
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter tree nodes (preorder), -1 for null:");
    Node root = buildTree(sc);

    System.out.println("BFS Traversal:");
    bfs(root);

    sc.close();
  }
}
