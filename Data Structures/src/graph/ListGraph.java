package graph;

import java.util.LinkedList;

/**
 * Created by Imran on 2/3/2020.
 */
public class ListGraph {
    private int numVertices;
    private LinkedList<Integer> adjLists[];

    public ListGraph(int numVertices) {
        this.numVertices = numVertices;
        adjLists = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++)
            adjLists[i] = new LinkedList();
    }

    private void addEdge(int i, int j) {
        adjLists[i].add(j);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(adjLists[i] + ": ");
            for (int j : adjLists[i]) {
                s.append(j + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[])
    {
        ListGraph lg = new ListGraph(4);

        lg.addEdge(0, 1);
        lg.addEdge(0, 2);
        lg.addEdge(1, 2);
        lg.addEdge(2, 0);
        lg.addEdge(2, 3);

        System.out.print(lg.toString());
    }
}
