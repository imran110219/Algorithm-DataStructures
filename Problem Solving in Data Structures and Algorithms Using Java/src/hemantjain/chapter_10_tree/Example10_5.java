package hemantjain.chapter_10_tree;

import java.util.ArrayDeque;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(n)
*/
public class Example10_5 {
    public void printBredthFirst(Node root) {
        ArrayDeque<Node> que = new ArrayDeque<Node>();
        Node temp;
        if (root != null)
            que.add(root);
        while (!que.isEmpty()) {
            temp = que.remove();
            System.out.println(temp.value);
            if (temp.lChild != null)
                que.add(temp.lChild);
            if (temp.rChild != null)
                que.add(temp.rChild);
        }
    }

    public static void main(String[] args) {
        Example10_1 t = new Example10_1();
        Example10_5 tree = new Example10_5();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = t.levelOrderBinaryTree(arr, 0);
        tree.printBredthFirst(node);
    }
}
