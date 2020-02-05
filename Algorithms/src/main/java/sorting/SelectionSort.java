package sorting;

/**
 * Created by Imran on 1/18/2020.
 */
public class SelectionSort {
    public void selectionSort(int arr[]){
        int len = arr.length;
        for(int i=0; i<len-1; i++){
            int minIndex = i;
            for(int j=i+1; j<len; j++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int array []= {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectionSort.selectionSort(array);
        selectionSort.printArray(array);
    }
}
