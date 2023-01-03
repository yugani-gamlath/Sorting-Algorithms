
public class HeapSort {

    // l=2*i+1;
    // r=2*i+2;

    void heap(int arr[], int n, int i) {

        int largest = i;
        int l = 2 * i + 1; // left
        int r = 2 * i + 2; // right

        // case: left child is larger than the root

        if (l < n && arr[l] > arr[largest]) {
            largest = 1;

            // case:right chid is larger than the largest
            if (r < n && arr[r] > arr[largest])
                largest = r;

            // case: if the largest is not the root

            if (largest != i) {

                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // recursively do heap the particular affected tree

                heap(arr, n, largest);

            }

        }

    }

    public void sort(int arr[]) {

        int n = arr.length;
        // re arranging the array

        for (int i = n / 2 - 1; i >= 0; i--) {

            heap(arr, n, i);
        }
        // one by one extract the element from te heap
        for (int i = n - 1; i >= 0; i--) {

            // move thecurrent root tothe end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heap on the reduced heap

            heap(arr, i, 0);

        }

    }

    static void printArray(int arr[]) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.println(arr[i] + "");
        System.out.println();

    }

    public static void main(String args[]) {

        int arr[] = { 12, 6, 8, 9, 5 };
        int n = arr.length;
        HeapSort H1 = new HeapSort();
        System.out.println("unsorted array");
        printArray(arr);
        H1.sort(arr);
        System.out.println("Sorted array");
        printArray(arr);

    }
}
