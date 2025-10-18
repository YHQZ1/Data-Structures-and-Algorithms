import java.util.*;

public class HM {
	static class HashMap<K, V> {

		private class Node {
			K key;
			V value;

			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private int n; // nodes;
		private int N; // buckets;
		private LinkedList<Node>[] buckets;

		public HashMap() {
			this.N = 4;
			this.buckets = new LinkedList[4];
			for (int i = 0; i < N; i++) {
				this.buckets[i] = new LinkedList<>();
			}
		}

		public void put(K key, V value) {

		}
	}
}