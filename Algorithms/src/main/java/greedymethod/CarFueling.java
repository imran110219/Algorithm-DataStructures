package greedymethod;

import java.util.Scanner;

/**
 * Created by Sadman on 2/24/2020.
 */
public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int n = stops.length;
        int numRefills = 0;
        int currentRefill = 0;
        int lastRefill = 0;
        while(currentRefill < n-1){
            lastRefill = currentRefill;
            while(currentRefill < n-1 && stops[currentRefill+1]-stops[lastRefill] <= tank ){
                currentRefill++;
            }
            if(currentRefill == lastRefill)
                return -1;
            if(currentRefill < n)
                numRefills++;
        }
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
