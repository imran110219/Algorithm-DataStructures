package greedymethod;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Imran on 2/15/2020.
 */
class ItemValue{
    Double cost;
    int weight;
    int value;

    public ItemValue(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.cost = new Double(value/weight);
    }
}

public class FractionalKnapSack {
    public static void solve(int[] weights, int[] values, int capacity){
        int size = weights.length;
        ItemValue[] itemList = new ItemValue[size];
        for(int i=0; i<weights.length; i++){
            itemList[i] = new ItemValue(weights[i], values[i]);
        }
        Arrays.sort(itemList, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });
        double totalCost = 0.0;
        for (ItemValue item:itemList) {
            if(capacity-item.weight >= 0){
                capacity -= item.weight;
                totalCost += item.value;
            }
            else {
                totalCost += capacity*item.cost;
                break;
            }
        }
        System.out.println((int)totalCost);
    }

    public static void main(String[] args)
    {
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;

        solve(wt,val,capacity);

    }
}
