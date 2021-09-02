package hemantjain.chapter_10_tree;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(n)
*/
public class Example10_3 {
    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.lChild);
            printPostOrder(node.rChild);
            System.out.print(" " + node.value);
        }
    }

    public static void main(String[] args) {
        Example10_1 t = new Example10_1();
        Example10_3 tree = new Example10_3();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = t.levelOrderBinaryTree(arr, 0);
        tree.printPostOrder(node);
    }
}
