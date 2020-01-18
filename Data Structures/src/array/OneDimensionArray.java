package array;

import complexity.AlgorithmComplexity;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Imran on 1/15/2020.
 */

public class OneDimensionArray {
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.print("Input Type: ");
        String inputType = input.nextLine();
        int a[] = new int[0];
        int size=0;
        if(inputType.equalsIgnoreCase("file")){

//            String fileName = input.nextLine();
            String prefix = "H:/Code Factory/Algorithm-DataStructures/Data Structures/in/";
            String fileName = "1D";
            String postfix = ".txt";
            Scanner fileInput = new Scanner(new File(prefix+fileName+postfix));
            size = fileInput.nextInt();
            a = new int[size];
            for (int i = 0; i < a.length; i++) {
                a[i] = fileInput.nextInt();
            }
        }
        else if(inputType.equalsIgnoreCase("console")){
            size = input.nextInt();
            a = new int[size];
            for (int i = 0; i < a.length; i++) {
                a[i] = input.nextInt();
            }
        }
        else if(inputType.equalsIgnoreCase("random")){
            Random rand = new Random();
            size = rand.nextInt(50);
            a = new int[size];
            for (int i = 0; i < a.length; i++) {
                a[i] = rand.nextInt(50);
            }
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
