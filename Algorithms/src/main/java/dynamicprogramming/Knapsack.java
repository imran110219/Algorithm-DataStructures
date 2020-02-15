package dynamicprogramming;

/**
 * Created by Imran on 2/14/2020.
 */
public class Knapsack {
    private int numOfItems;
    private int capacityOfKnapsack;
    private int[][] knapsackTable;
    private int totalBenefit;
    private int[] weights;
    private int[] values;

    public Knapsack(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
        this.numOfItems = numOfItems;
        this.capacityOfKnapsack = capacityOfKnapsack;
        this.weights = weights;
        this.values = values;
        this.knapsackTable = new int[numOfItems+1][capacityOfKnapsack+1];
    }

    public void solve() {
        // time complexity: O(N*W)
        for(int i=1; i<=numOfItems; i++){
            for(int w=1; w<=capacityOfKnapsack; w++){
                int notTakingItem = knapsackTable[i-1][w];
                int takingItem = 0;
                if(weights[i] <= w) {
                    takingItem = values[i] + knapsackTable[i-1][w-weights[i]];
                }
                knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
            }
        }
        totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
        System.out.println(totalBenefit);
    }

    public static void main(String[] args) {
        int numOfItems = 4;
        int[] weights = {10, 40, 20, 30};
        int[] values = {60, 40, 100, 120};
        int capacityOfKnapsack = 50;
        Knapsack knapsack = new Knapsack(numOfItems, capacityOfKnapsack, weights, values);
        knapsack.solve();
    }
}
