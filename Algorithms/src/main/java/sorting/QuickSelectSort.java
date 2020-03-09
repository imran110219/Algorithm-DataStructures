package sorting;

/**
 * Created by Sadman on 3/9/2020.
 */
public class QuickSelectSort {

    public void swap(int arr[], int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public void quickSelect(int arr[], int lower, int upper,int k)
    {
        if (upper <= lower)
            return;
        int pivot = arr[lower];
        int start = lower;
        int stop = upper;
        while (lower < upper)
        {
            while (arr[lower] <= pivot && lower < upper)
                lower++;
            while (arr[upper] > pivot && lower <= upper)
                upper--;
            if (lower < upper)
                swap(arr, upper, lower);

        }
        swap(arr, upper, start); //upper is the pivot position
        if (k<upper)
            quickSelect(arr, start, upper - 1, k); //pivot -1 is the upper for left sub array.
        if (k>upper)
            quickSelect(arr, upper + 1, stop, k); // pivot + 1 is the lower for right sub array.

    }
    public void quickSelect(int arr[], int k){
        quickSelect(arr, 0, arr.length - 1, k);
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSelectSort quickSelectSort = new QuickSelectSort();
        int[] array={3,4,2,1,6,5,7,8,10,9};
        quickSelectSort.quickSelect(array, 5);
        quickSelectSort.printArray(array);
        System.out.print("value at index 5 is : "+ array[4]);
    }
}
