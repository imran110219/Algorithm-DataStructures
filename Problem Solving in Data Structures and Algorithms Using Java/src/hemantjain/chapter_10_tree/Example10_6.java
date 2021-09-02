package hemantjain.chapter_10_tree;

import java.util.ArrayDeque;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(n)
*/
public class Example10_6 {
    public void printDepthFirst(Node root){
        ArrayDeque<Node> stk = new ArrayDeque<Node>();
        Node temp;
        if(root != null)
            stk.push(root);
        while(!stk.isEmpty())
        {
            temp= stk.pop();
            System.out.print(temp.value + " ");
            if(temp.lChild != null)
                stk.push(temp.lChild);
            if(temp.rChild != null)
                stk.push(temp.rChild);
        }
    }

    public static void main(String[] args) {
        Example10_1 t = new Example10_1();
        Example10_6 tree = new Example10_6();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = t.levelOrderBinaryTree(arr, 0);
        tree.printDepthFirst(node);
    }
}
