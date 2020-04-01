package trie;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Sadman on 3/12/2020.
 */
public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    public TrieNode() {}
    public TrieNode(char c){
        this.c = c;
    }
}
