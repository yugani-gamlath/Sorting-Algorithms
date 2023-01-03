public class selectionSort {  
    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;// searching for lowest index
                }
            }
            final int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void main(final String a[]) {
        final int[] arr1 = { 9, 14, 3, 2, 43, 11, 58, 22 };
        System.out.println("Before Selection Sort");
        for (final int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        selection(arr1);// sorting array using selection sort

        System.out.println("After Selection Sort");
        for (final int i : arr1) {
            System.out.print(i+" ");  
        }  
    }  
}  