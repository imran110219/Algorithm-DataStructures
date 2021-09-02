package hemantjain.chapter_10_tree;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(n)
*/
public class Example10_2 {
    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            printPreOrder(node.lChild);
            printPreOrder(node.rChild);
        }
    }

    public static void main(String[] args) {
        Example10_1 t = new Example10_1();
        Example10_2 tree = new Example10_2();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = t.levelOrderBinaryTree(arr,0);
        tree.printPreOrder(node);
    }
}
