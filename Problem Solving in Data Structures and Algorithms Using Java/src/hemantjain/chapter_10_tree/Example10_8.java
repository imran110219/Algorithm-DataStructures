package hemantjain.chapter_10_tree;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(n)
*/
public class Example10_8 {
    public void nthPreOrder(int index, Node root) {
        nthPreOrder(root, index, 0);
    }

    private void nthPreOrder(Node node, int index, int counter) /* pre order */ {
        if (node != null) {
            counter++;
            if (counter == index) {
                System.out.print(" " + node.value);
            }
            nthPreOrder(node.lChild, index, counter);
            nthPreOrder(node.rChild, index, counter);
        }
    }

    public static void main(String[] args) {
        Example10_1 t = new Example10_1();
        Example10_8 tree = new Example10_8();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = t.levelOrderBinaryTree(arr, 0);
        tree.nthPreOrder(2, node);
    }
}
