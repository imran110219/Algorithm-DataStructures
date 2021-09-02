package hemantjain.chapter_10_tree;

import java.util.ArrayDeque;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(n)
*/
public class Example10_7 {
    private int treeDepth(Node root) {
        if(root == null)
            return 0;
        else
        {
            int lDepth=treeDepth(root.lChild);
            int rDepth=treeDepth(root.rChild);
            if(lDepth>rDepth)
                return lDepth+1;
            else
                return rDepth+1;
        }
    }

    public static void main(String[] args) {
        Example10_1 t = new Example10_1();
        Example10_7 tree = new Example10_7();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = t.levelOrderBinaryTree(arr, 0);
        tree.treeDepth(node);
    }
}
