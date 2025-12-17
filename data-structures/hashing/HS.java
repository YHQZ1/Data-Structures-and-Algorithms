import java.util.LinkedList;
import java.util.Scanner;

public class HS {

	private static final int INITIAL_CAPACITY = 16;
	private static final double LOAD_FACTOR = 0.75;

	private LinkedList<Integer>[] buckets;
	private int size;

	public HS() {
		buckets = new LinkedList[INITIAL_CAPACITY];
		size = 0;
	}

	private int hash(int key) {
		return Math.abs(key) % buckets.length;
	}

	public boolean add(int key) {
		int index = hash(key);
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<>();
		}
		if (buckets[index].contains(key)) {
			return false;
		}
		buckets[index].add(key);
		size++;
		if ((double) size / buckets.length >= LOAD_FACTOR) {
			resize();
		}
		return true;
	}

	public boolean remove(int key) {
		int index = hash(key);
		if (buckets[index] == null)
			return false;
		boolean removed = buckets[index].remove((Integer) key);
		if (removed)
			size--;
		return removed;
	}

	public boolean contains(int key) {
		int index = hash(key);
		if (buckets[index] == null)
			return false;
		return buckets[index].contains(key);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void clear() {
		buckets = new LinkedList[INITIAL_CAPACITY];
		size = 0;
	}

	public Integer[] toArray() {
		Integer[] arr = new Integer[size];
		int idx = 0;
		for (LinkedList<Integer> bucket : buckets) {
			if (bucket != null) {
				for (int val : bucket) {
					arr[idx++] = val;
				}
			}
		}
		return arr;
	}

	public HS cloneSet() {
		HS newSet = new HS();
		for (LinkedList<Integer> bucket : buckets) {
			if (bucket != null) {
				for (int val : bucket) {
					newSet.add(val);
				}
			}
		}
		return newSet;
	}

	private void resize() {
		LinkedList<Integer>[] oldBuckets = buckets;
		buckets = new LinkedList[oldBuckets.length * 2];
		size = 0;
		for (LinkedList<Integer> bucket : oldBuckets) {
			if (bucket != null) {
				for (int key : bucket) {
					add(key);
				}
			}
		}
	}

	public void display() {
		System.out.print("Set elements: ");
		for (LinkedList<Integer> bucket : buckets) {
			if (bucket != null) {
				for (int val : bucket) {
					System.out.print(val + " ");
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HS set = new HS();
		boolean exit = false;

		while (!exit) {
			System.out.println("\nChoose an operation:");
			System.out.println("1. Add element");
			System.out.println("2. Remove element");
			System.out.println("3. Check if element exists");
			System.out.println("4. Check if set is empty");
			System.out.println("5. Display set");
			System.out.println("6. Get set size");
			System.out.println("7. Clone set");
			System.out.println("8. Convert to array");
			System.out.println("9. Clear set");
			System.out.println("10. Exit");

			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter element: ");
					System.out.println(set.add(sc.nextInt()) ? "Added" : "Already exists");
					break;

				case 2:
					System.out.print("Enter element: ");
					System.out.println(set.remove(sc.nextInt()) ? "Removed" : "Not found");
					break;

				case 3:
					System.out.print("Enter element: ");
					System.out.println(set.contains(sc.nextInt()));
					break;

				case 4:
					System.out.println(set.isEmpty());
					break;

				case 5:
					set.display();
					break;

				case 6:
					System.out.println("Size: " + set.size());
					break;

				case 7:
					HS cloned = set.cloneSet();
					System.out.println("Cloned Set:");
					cloned.display();
					break;

				case 8:
					Integer[] arr = set.toArray();
					for (int val : arr) {
						System.out.print(val + " ");
					}
					System.out.println();
					break;

				case 9:
					set.clear();
					System.out.println("Set cleared");
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
