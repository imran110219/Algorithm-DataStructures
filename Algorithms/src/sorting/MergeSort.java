package sorting;

/**
 * Created by Imran on 1/20/2020.
 */
public class MergeSort {

    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] arr) {
        int size = arr.length;
        if(size<2)
            return;
        int mid = size/2;
        int[] left = new int[mid];
        int[] right = new int[size-mid];
        for(int i=0; i<left.length; i++)
            left[i] = arr[i];
        for(int j=mid; j<right.length; j++)
            left[j-mid] = arr[j];
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int array []= {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort.mergeSort(array);
        mergeSort.printArray(array);
    }

}
