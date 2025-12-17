import java.util.Scanner;

public class Trie {

  static class Node {
    Node[] children = new Node[26];
    boolean isEnd;
  }

  Node root = new Node();

  void insert(String word) {
    Node curr = root;
    for (char c : word.toCharArray()) {
      int idx = c - 'a';
      if (curr.children[idx] == null)
        curr.children[idx] = new Node();
      curr = curr.children[idx];
    }
    curr.isEnd = true;
    System.out.println("Inserted: " + word);
  }

  boolean search(String word) {
    Node curr = root;
    for (char c : word.toCharArray()) {
      int idx = c - 'a';
      if (curr.children[idx] == null)
        return false;
      curr = curr.children[idx];
    }
    return curr.isEnd;
  }

  boolean startsWith(String prefix) {
    Node curr = root;
    for (char c : prefix.toCharArray()) {
      int idx = c - 'a';
      if (curr.children[idx] == null)
        return false;
      curr = curr.children[idx];
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Trie trie = new Trie();

    while (true) {
      System.out.println("\n1.Insert 2.Search 3.StartsWith 4.Exit");
      int ch = sc.nextInt();
      sc.nextLine();

      if (ch == 1) {
        System.out.print("Enter word: ");
        trie.insert(sc.nextLine().toLowerCase());
      } else if (ch == 2) {
        System.out.print("Enter word: ");
        System.out.println(trie.search(sc.nextLine().toLowerCase()));
      } else if (ch == 3) {
        System.out.print("Enter prefix: ");
        System.out.println(trie.startsWith(sc.nextLine().toLowerCase()));
      } else {
        break;
      }
    }
    sc.close();
  }
}
