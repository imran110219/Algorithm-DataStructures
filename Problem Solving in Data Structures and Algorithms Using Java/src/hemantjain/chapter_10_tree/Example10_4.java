package hemantjain.chapter_10_tree;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(n)
*/
public class Example10_4 {
    private void printInOrder(Node node)/* In order */ {
        if (node != null) {
            printInOrder(node.lChild);
            System.out.print(" " + node.value);
            printInOrder(node.rChild);
        }
    }

    public static void main(String[] args) {
        Example10_1 t = new Example10_1();
        Example10_4 tree = new Example10_4();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = t.levelOrderBinaryTree(arr, 0);
        tree.printInOrder(node);
    }
}
