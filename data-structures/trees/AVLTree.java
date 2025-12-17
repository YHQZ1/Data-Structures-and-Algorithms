import java.util.Scanner;

public class AVLTree {

  class Node {
    int data, height;
    Node left, right;

    Node(int data) {
      this.data = data;
      height = 1;
    }
  }

  Node root;

  int height(Node n) {
    return n == null ? 0 : n.height;
  }

  int balance(Node n) {
    return n == null ? 0 : height(n.left) - height(n.right);
  }

  Node rightRotate(Node y) {
    Node x = y.left;
    Node t = x.right;

    x.right = y;
    y.left = t;

    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    return x;
  }

  Node leftRotate(Node x) {
    Node y = x.right;
    Node t = y.left;

    y.left = x;
    x.right = t;

    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    return y;
  }

  Node insert(Node node, int val) {
    if (node == null)
      return new Node(val);

    if (val < node.data)
      node.left = insert(node.left, val);
    else if (val > node.data)
      node.right = insert(node.right, val);
    else
      return node;

    node.height = 1 + Math.max(height(node.left), height(node.right));
    int bf = balance(node);

    if (bf > 1 && val < node.left.data)
      return rightRotate(node);
    if (bf < -1 && val > node.right.data)
      return leftRotate(node);
    if (bf > 1 && val > node.left.data) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    if (bf < -1 && val < node.right.data) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
    return node;
  }

  void inorder(Node node) {
    if (node == null)
      return;
    inorder(node.left);
    System.out.print(node.data + " ");
    inorder(node.right);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AVLTree tree = new AVLTree();

    while (true) {
      System.out.println("\n1.Insert 2.Inorder 3.Exit");
      int ch = sc.nextInt();

      if (ch == 1)
        tree.root = tree.insert(tree.root, sc.nextInt());
      else if (ch == 2) {
        tree.inorder(tree.root);
        System.out.println();
      } else {
        sc.close();
        return;
      }
    }
  }
}
