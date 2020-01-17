package complexity;

/**
 * Created by Imran on 1/17/2020.
 */
public class AlgorithmComplexity {
    public static String checkComplexity(int execution, int number){
        if(execution == 1)
            return "O(1)";
        else if(execution == number)
            return "O(n)";
        else if(Math.pow(2,execution) == number)
            return "O(logn)";
        else if(Math.pow(number,2) == execution)
            return "O(n^2)";
        return "";
    }
}
