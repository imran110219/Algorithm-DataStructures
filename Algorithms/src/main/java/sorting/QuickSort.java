package sorting;

/**
 * Created by Imran on 1/24/2020.
 */
public class QuickSort {
    public void quickSort(int arr[], int start, int end){
        if(start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex+1, end);
        }
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for(int i=start; i<end; i++){
            if(arr[i]<=pivot){
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int array []= {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort.quickSort(array, 0, array.length-1);
        quickSort.printArray(array);
    }

}
