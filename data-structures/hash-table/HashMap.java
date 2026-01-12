import java.util.LinkedList;
import java.util.Scanner;

public class HashMap {

	static class Entry {
		int key;
		int value;

		Entry(int k, int v) {
			key = k;
			value = v;
		}
	}

	private static final int INITIAL_CAPACITY = 16;
	private static final double LOAD_FACTOR = 0.75;

	private LinkedList<Entry>[] buckets;
	private int size;

	public HashMap() {
		buckets = new LinkedList[INITIAL_CAPACITY];
		size = 0;
	}

	private int hash(int key) {
		return Math.abs(key) % buckets.length;
	}

	public void put(int key, int value) {
		int index = hash(key);
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<>();
		}
		for (Entry e : buckets[index]) {
			if (e.key == key) {
				e.value = value;
				return;
			}
		}
		buckets[index].add(new Entry(key, value));
		size++;
		if ((double) size / buckets.length >= LOAD_FACTOR) {
			resize();
		}
	}

	public Integer get(int key) {
		int index = hash(key);
		if (buckets[index] == null)
			return null;
		for (Entry e : buckets[index]) {
			if (e.key == key)
				return e.value;
		}
		return null;
	}

	public boolean containsKey(int key) {
		int index = hash(key);
		if (buckets[index] == null)
			return false;
		for (Entry e : buckets[index]) {
			if (e.key == key)
				return true;
		}
		return false;
	}

	public boolean remove(int key) {
		int index = hash(key);
		if (buckets[index] == null)
			return false;
		for (Entry e : buckets[index]) {
			if (e.key == key) {
				buckets[index].remove(e);
				size--;
				return true;
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		buckets = new LinkedList[INITIAL_CAPACITY];
		size = 0;
	}

	private void resize() {
		LinkedList<Entry>[] oldBuckets = buckets;
		buckets = new LinkedList[oldBuckets.length * 2];
		size = 0;

		for (LinkedList<Entry> bucket : oldBuckets) {
			if (bucket != null) {
				for (Entry e : bucket) {
					put(e.key, e.value);
				}
			}
		}
	}

	public void display() {
		System.out.println("HashMap contents:");
		for (int i = 0; i < buckets.length; i++) {
			System.out.print(i + ": ");
			if (buckets[i] != null) {
				for (Entry e : buckets[i]) {
					System.out.print("(" + e.key + " -> " + e.value + ") ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap map = new HashMap();
		boolean exit = false;

		while (!exit) {
			System.out.println("\nChoose an operation:");
			System.out.println("1. Put (key, value)");
			System.out.println("2. Get value by key");
			System.out.println("3. Remove key");
			System.out.println("4. Check if key exists");
			System.out.println("5. Get map size");
			System.out.println("6. Check if map is empty");
			System.out.println("7. Display map");
			System.out.println("8. Clear map");
			System.out.println("9. Exit");

			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter key: ");
					int key = sc.nextInt();
					System.out.print("Enter value: ");
					int value = sc.nextInt();
					map.put(key, value);
					System.out.println("Inserted/Updated");
					break;

				case 2:
					System.out.print("Enter key: ");
					Integer val = map.get(sc.nextInt());
					System.out.println(val != null ? val : "Key not found");
					break;

				case 3:
					System.out.print("Enter key: ");
					System.out.println(map.remove(sc.nextInt()) ? "Removed" : "Key not found");
					break;

				case 4:
					System.out.print("Enter key: ");
					System.out.println(map.containsKey(sc.nextInt()));
					break;

				case 5:
					System.out.println("Size: " + map.size());
					break;

				case 6:
					System.out.println(map.isEmpty());
					break;

				case 7:
					map.display();
					break;

				case 8:
					map.clear();
					System.out.println("Map cleared");
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
