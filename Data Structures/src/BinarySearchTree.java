import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * Created by Imran on 1/6/2020.
 */
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }
}

public class BinarySearchTree {

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void preOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }

//    public static void levelOrder(Node root) {
//        Queue<Node> queue = new ArrayList<>();
//        if(root == null)
//            return;
//        else {
//            queue.add(root);
//            while(!queue.isEmpty()){
//                Node temp = queue.remove();
//                System.out.print(temp.data+" ");
//                if(temp.left != null){
//                    queue.add(temp.left);
//                }
//                if(temp.right != null){
//                    queue.add(temp.right);
//                }
//            }
//        }
//    }

    public static int height(Node root) {
        if(root == null)
            return -1;
        return Math.max(height(root.left),height(root.right))+1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inOrder(root);
        preOrder(root);
        postOrder(root);
//        levelOrder(root);
    }
}
