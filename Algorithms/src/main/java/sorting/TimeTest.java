package sorting;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Imran on 1/27/2020.
 */
public class TimeTest {

    public static void main(String[] args) {

        // Generate array with random number
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int size = scan.nextInt();
        int[] arr = new int[size];

        for(int i=0;i<size;i++)
        {
            arr[i] = random.nextInt();
        }

        long startTime = System.currentTimeMillis();
        new BubbleSort().sort(arr);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Bubble Sort : " + elapsedTime);

        for(int i=0;i<size;i++)
        {
            arr[i] = random.nextInt();
        }

        startTime = System.currentTimeMillis();
        new InsertionSort().sort(arr);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Insertion Sort : " + elapsedTime);

//        for(int i=0;i<size;i++)
//        {
//            arr[i] = random.nextInt();
//        }
//
//        startTime = System.currentTimeMillis();
//        new BucketSort().sort(arr);
//        stopTime = System.currentTimeMillis();
//        elapsedTime = stopTime - startTime;
//        System.out.println("Bucket  Sort : " + elapsedTime);

        for(int i=0;i<size;i++)
        {
            arr[i] = random.nextInt();
        }

        startTime = System.currentTimeMillis();
        new MergeSort().sort(arr);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Merge Sort : " + elapsedTime);

        for(int i=0;i<size;i++)
        {
            arr[i] = random.nextInt();
        }

        startTime = System.currentTimeMillis();
        new SelectionSort().sort(arr);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Selection Sort : " + elapsedTime);
    }
}
