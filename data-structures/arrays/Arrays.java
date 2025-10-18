import java.util.Scanner;

public class Arrays {

	public static void displayArray(int[] arr, int size) {
		System.out.print("Array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int insertElement(int[] arr, int size, Scanner sc) {
		if (size >= arr.length) {
			System.out.println("Array is full, cannot insert!");
			return size;
		}
		System.out.print("Enter index to insert at: ");
		int index = sc.nextInt();
		if (index < 0 || index > size) {
			System.out.println("Invalid index!");
			return size;
		}
		System.out.print("Enter element to insert: ");
		int value = sc.nextInt();

		for (int i = size; i > index; i--) {
			arr[i] = arr[i - 1];
		}
		arr[index] = value;
		System.out.println("Element inserted successfully!");
		return size + 1;
	}

	public static int deleteElement(int[] arr, int size, Scanner sc) {
		if (size == 0) {
			System.out.println("Array is empty, cannot delete!");
			return size;
		}
		System.out.print("Enter index to delete from: ");
		int index = sc.nextInt();
		if (index < 0 || index >= size) {
			System.out.println("Invalid index!");
			return size;
		}

		for (int i = index; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		System.out.println("Element deleted successfully!");
		return size - 1;
	}

	public static void checkSize(int size) {
		System.out.println("Current number of elements in the array: " + size);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int size;

		System.out.print("Enter number of elements: ");
		size = sc.nextInt();

		System.out.println("Enter " + size + " elements:");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Display Array");
			System.out.println("2. Insert Element");
			System.out.println("3. Delete Element");
			System.out.println("4. Check Array Size");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					displayArray(arr, size);
					break;
				case 2:
					size = insertElement(arr, size, sc);
					break;
				case 3:
					size = deleteElement(arr, size, sc);
					break;
				case 4:
					checkSize(size);
					break;
				case 5:
					System.out.println("Exiting...");
					sc.close();
					return;
				default:
					System.out.println("Invalid choice, try again.");
			}
		}
	}
}