import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static int binarySearch(int[] arr, int target) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
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

		Arrays.sort(arr);
		System.out.println("\nSorted Array: " + Arrays.toString(arr));

		System.out.print("Enter the element to search for: ");
		int target = sc.nextInt();

		int result = binarySearch(arr, target);

		if (result != -1) {
			System.out.println("Element found at index: " + result);
		} else {
			System.out.println("Element not found in the array.");
		}

		sc.close();
	}
}
