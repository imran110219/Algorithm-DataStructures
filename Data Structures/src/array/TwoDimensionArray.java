package array;

import complexity.TimeComplexity;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Imran on 1/16/2020.
 */
public class TwoDimensionArray {
    public static void main(String args[])  throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Input Type: ");
        String inputType = input.nextLine();
        int size = 0;
        int a[][]=new int[size][size];
        if(inputType.equalsIgnoreCase("file")){
            String prefix = "H:/Code Factory/Algorithm-DataStructures/Data Structures/in/";
            String fileName = "2D";
            String postfix = ".txt";
            Scanner fileInput = new Scanner(new File(prefix+fileName+postfix));
            size = fileInput.nextInt();
            a = new int[size][size];
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    a[i][j] = fileInput.nextInt();
                }
            }
        }
        else if(inputType.equalsIgnoreCase("console")){
            size = input.nextInt();
            a = new int[size][size];
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    a[i][j] = input.nextInt();
                }
            }
        }
        else if(inputType.equalsIgnoreCase("random")){
            Random rand = new Random();
            size = rand.nextInt(50);
            a = new int[size][size];
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    a[i][j] = rand.nextInt(50);
                }
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
        System.out.println("The Complexity of this program is "+ TimeComplexity.checkComplexity(counter, size));
    }
}
