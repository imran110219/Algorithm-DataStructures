package array;

import complexity.AlgorithmComplexity;

import java.util.Scanner;

/**
 * Created by Imran on 1/16/2020.
 */
public class TwoDimensionArray {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int a[][]=new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                a[i][j] = input.nextInt();
            }
        }
        int  counter = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++) {
                System.out.print(a[i][j] + " ");
                counter++;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("The Complexity of this program is "+ AlgorithmComplexity.checkComplexity(counter, size));
    }
}
