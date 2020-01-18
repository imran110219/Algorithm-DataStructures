package sorting;

/**
 * Created by Imran on 1/5/2020.
 */
public class BubbleSort {
    public void bubbleSort(int arr[]){
        int len = arr.length;
        for(int i=0; i<len-1; i++)
            for(int j=0; j<len-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
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
        BubbleSort bubbleSort = new BubbleSort();
        int array []= {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort.bubbleSort(array);
        bubbleSort.printArray(array);
    }
}
