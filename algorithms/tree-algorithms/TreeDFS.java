import java.util.Scanner;

public class TreeDFS {

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

  static void dfs(Node root) {
    if (root == null)
      return;
    System.out.print(root.data + " ");
    dfs(root.left);
    dfs(root.right);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter tree nodes (preorder), -1 for null:");
    Node root = buildTree(sc);

    System.out.println("DFS Traversal:");
    dfs(root);

    sc.close();
  }
}
