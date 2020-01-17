package array;

import complexity.AlgorithmComplexity;

import java.util.Scanner;

/**
 * Created by Imran on 1/15/2020.
 */
public class Array {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int a[]=new int[size];
        for(int i=0; i<a.length; i++){
            a[i] = input.nextInt();
        }
        int  counter = 0;
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+ " ");
            counter++;
        }
        System.out.println();
        System.out.println("The Complexity of this program is "+ AlgorithmComplexity.checkComplexity(counter, size));

    }
}
