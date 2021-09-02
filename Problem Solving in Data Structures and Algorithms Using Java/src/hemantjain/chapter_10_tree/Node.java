package hemantjain.chapter_10_tree;

/**
 * @author Sadman
 */
public class Node {
    int value;
    Node lChild;
    Node rChild;
    public Node( int v, Node l, Node r) {
        value = v;
        lChild = l;
        rChild = r;
    }
    public Node( int v ) {
        value = v;
        lChild = null;
        rChild = null;
    }
}
