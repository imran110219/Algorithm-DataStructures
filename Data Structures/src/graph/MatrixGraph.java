package graph;

/**
 * Created by Imran on 1/11/2020.
 */
public class MatrixGraph {
    private boolean adjMatrix[][];
    private int numVertices;

    public MatrixGraph(int numVertices){
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int i, int j){
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    public void removeEdge(int i, int j){
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    public boolean isEdge(int i, int j){
        return adjMatrix[i][j];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j?1:0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[])
    {
        MatrixGraph mg = new MatrixGraph(4);

        mg.addEdge(0, 1);
        mg.addEdge(0, 2);
        mg.addEdge(1, 2);
        mg.addEdge(2, 0);
        mg.addEdge(2, 3);

        System.out.print(mg.toString());
    }
}
