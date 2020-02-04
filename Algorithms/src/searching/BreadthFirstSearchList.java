package searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Imran on 2/4/2020.
 */
public class BreadthFirstSearchList {
    private Queue<Node> queue;
    static ArrayList<Node> nodes=new ArrayList<Node>();

    public BreadthFirstSearchList()
    {
        queue = new LinkedList<Node>();
    }

    static class Node
    {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int data)
        {
            this.data=data;
            this.neighbours=new ArrayList<>();
        }
        public void addneighbours(Node neighbourNode)
        {
            this.neighbours.add(neighbourNode);
        }
        public List<Node> getNeighbours() {
            return neighbours;
        }
        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    public void bfs(Node node)
    {
        queue.add(node);
        node.visited=true;
        while (!queue.isEmpty())
        {
            Node element=queue.remove();
            System.out.print(element.data + "   ");
            List<Node> neighbours=element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n=neighbours.get(i);
                if(n!=null && !n.visited) {
                    queue.add(n);
                    n.visited=true;
                }
            }
        }
    }

    public static void main(String arg[])
    {
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);
        System.out.println("The BFS traversal of the graph is ");
        BreadthFirstSearchList bfsList = new BreadthFirstSearchList();
        bfsList.bfs(node40);

    }
}
