/**
 * Created by Imran on 1/4/2020.
 */
public class BinaryTree {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public void insert(Node node, int value){
        Node temp = node;
        Node newNode = new Node(value);
        if(node == null)
            node = newNode;
        else{
            if(node.left == null)
                node.left = newNode;
            else if(node.right == null)
                node.right = newNode;
            else{
                if(node.left.left != null && node.left.right != null)
                    insert(node.right, value);
                else
                    insert(node.left, value);
            }
        }
    }

    public static void main(String args[])
    {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1);
        binaryTree.insert(root,2);
        binaryTree.insert(root,3);
        binaryTree.insert(root,4);
        System.out.println(root.left.value+"    "+root.right.value);
    }
}
