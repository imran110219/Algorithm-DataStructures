package trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("and");
        trie.insert("add");
        trie.insert("cat");
        trie.insert("sad");
        trie.insert("dog");
        trie.insert("day");
        System.out.println(trie.search("dog"));
    }
}
