package hemantjain.chapter_10_tree;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(n)
*/
public class Example10_1 {
    public Node levelOrderBinaryTree(int[] arr, int start) {
        int size = arr.length;
        Node curr = new Node(arr[start]);
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        if (left < size)
            curr.lChild = levelOrderBinaryTree(arr, left);
        if (right < size)
            curr.rChild = levelOrderBinaryTree(arr, right);
        return curr;
    }

    public static void main(String[] args) {
        Example10_1 t = new Example10_1();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = t.levelOrderBinaryTree(arr, 0);
    }
}
