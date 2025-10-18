import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;

			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			if (!swapped)
				break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of elements: ");
		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Enter element " + (i + 1) + ": ");
			arr[i] = sc.nextInt();
		}

		System.out.println("\nOriginal Array: " + Arrays.toString(arr));

		bubbleSort(arr);

		System.out.println("Sorted Array (Bubble Sort): " + Arrays.toString(arr));
		sc.close();
	}
}
