package hashing;

/**
 * Created by Sadman on 3/10/2020.
 */
public class HashNode {

    String value;
    // Linked list of same hash entries.
    HashNode next;

    public HashNode(String value) {
        this.value = value;
        this.next = null;
    }

}
