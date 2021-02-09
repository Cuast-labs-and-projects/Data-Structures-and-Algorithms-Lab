
import java.util.Scanner;

public class bubbleSort {

    void bubblesort(int arr[], int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {

        bubbleSort obj = new bubbleSort();
        Scanner s = new Scanner(System.in);

        System.out.println("enter the number of elements");

        int n = s.nextInt();

        int arr[] = new int[n];

        System.out.println("enter the numbers");

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        s.close();

        obj.bubblesort(arr, n);

        System.out.println("the array after sorting is ...");

        for (int i : arr) {
            System.out.println(i);
        }

    }
}
