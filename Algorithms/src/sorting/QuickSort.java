package sorting;

/**
 * Created by Imran on 1/24/2020.
 */
public class QuickSort {
    public void quickSort(int arr[], int start, int end){
        if(start >= end)
            return;
        int pIndex = 0;//partition(arr, start, end);
        quickSort(arr, start, pIndex-1);
        quickSort(arr, pIndex, end);
    }

}
