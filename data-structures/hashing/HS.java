import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;

public class HS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> set = new HashSet<>();
		boolean exit = false;

		System.out.println(("Enter your choice: "));
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
			System.out.println("9. Remove elements in bulk");
			System.out.println("10. Clear set");
			System.out.println("11. Iterate using enhanced for-loop");
			System.out.println("12. Iterate using Iterator");
			System.out.println("13. Exit");

			System.out.print("Enter your choice (1-13): ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Enter an element to add: ");
					int elementToAdd = sc.nextInt();
					boolean added = set.add(elementToAdd);
					System.out.println(added ? "Element added successfully!" : "Element already exists in the set.");
					break;

				case 2:
					System.out.println("Enter the element you want to remove: ");
					int elementToRemove = sc.nextInt();
					boolean removed = set.remove(elementToRemove);
					System.out.println(removed ? "Element removed successfully!" : "Element not found in the set.");
					break;

				case 3:
					System.out.println("Enter the element to check: ");
					int checkElement = sc.nextInt();
					System.out.println(
							set.contains(checkElement) ? "Element exists in the set." : "Element does not exist in the set.");
					break;

				case 4:
					System.out.println(set.isEmpty() ? "Set is empty." : "Set is not empty.");
					break;

				case 5:
					System.out.println("Current elements in the set: " + set);
					break;

				case 6:
					System.out.println("Size of the set: " + set.size());
					break;

				case 7:
					HashSet<Integer> clonedSet = new HashSet<>(set);
					System.out.println("Cloned set: " + clonedSet);
					break;

				case 8:
					Integer[] array = set.toArray(new Integer[0]);
					System.out.print("Set converted to array: ");
					for (Integer num : array) {
						System.out.print(num + " ");
					}
					System.out.println();
					break;

				case 9:
					System.out.print("Enter number of elements to remove in bulk: ");
					int n2 = sc.nextInt();
					HashSet<Integer> removeSet = new HashSet<>();
					System.out.println("Enter " + n2 + " element(s):");
					for (int i = 0; i < n2; i++)
						removeSet.add(sc.nextInt());
					set.removeAll(removeSet);
					System.out.println("After bulk removal: " + set);
					break;

				case 10:
					set.clear();
					System.out.println("Set cleared successfully!");
					break;

				case 11:
					System.out.println("Iterating using enhanced for-loop:");
					for (int num : set) {
						System.out.println(num);
					}
					break;

				case 12:
					System.out.println("Iterating using Iterator:");
					Iterator<Integer> it = set.iterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}
					break;

				case 13:
					exit = true;
					System.out.println("Exiting...");
					break;

				default:
					System.out.println("Invalid choice! Please try again.");
					break;
			}
		}
		sc.close();
	}
}
