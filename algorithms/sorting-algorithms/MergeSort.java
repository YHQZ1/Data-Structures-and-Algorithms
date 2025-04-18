import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
  public static void merge(int[] arr, int left, int mid, int right){
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for(int i=0; i<n1; i++){
      L[i] = arr[left + i];
    }
    for(int i=0; i<n2; i++){
      R[i] = arr[mid + 1 + i];
    }

    int i=0, j=0, k=left;
    while(i<n1 && j<n2){
      if(L[i] <= R[j]){
        arr[k++] = L[i++];
      } else {
        arr[k++] = R[j++];
      }
    }

    while(i<n1){
      arr[k++] = L[i++];
    }
    while(j<n2){
      arr[k++] = R[j++];
    }
  }

  public static void mergeSort(int[] arr, int left, int right){
    if(left < right){
      int mid = (left + right)/2;

      mergeSort(arr, left, mid);
      mergeSort(arr, mid+1, right);

      merge(arr, left, mid, right);
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

    mergeSort(arr, 0, n - 1);

    System.out.println("Sorted Array (Merge Sort): " + Arrays.toString(arr));
    sc.close();
  }
}
