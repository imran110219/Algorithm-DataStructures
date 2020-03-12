package sorting;

/**
 * Created by Imran on 1/18/2020.
 */
public class InsertionSort{
    public static void sort(int arr[]){
        int len = arr.length;
        int value = 0;
        int hole = 0;
        for(int i=0; i<len; i++){
            value = arr[i];
            hole = i;
            while(hole>0 && arr[hole-1]>value){
                arr[hole] = arr[hole-1];
                hole--;
            }
            arr[hole] = value;
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
        InsertionSort insertionSort = new InsertionSort();
        int array []= {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertionSort.sort(array);
        insertionSort.printArray(array);
    }
}
