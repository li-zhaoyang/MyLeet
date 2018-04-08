import java.util.*;
class Trie {
    class TrieNode {
      char val;
      TrieNode[] children;
      boolean hasWord;
      public TrieNode(char c) {
        val = c;
        children = new TrieNode[26];
        hasWord = false;
      }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
      root = new TrieNode('0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      insertHelper(word, root);
    }
    private void insertHelper(String word, TrieNode thisNode) {
      if (word.length() == 0) {
        thisNode.hasWord = true;
        return;
      }
      if (thisNode.children[word.charAt(0) - 'a'] == null) thisNode.children[word.charAt(0) - 'a'] = new TrieNode(word.charAt(0));
      insertHelper(word.substring(1), thisNode.children[word.charAt(0) - 'a']);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      return searchHelper(word, root);
    }
    private boolean searchHelper(String word, TrieNode thisNode) {
      if (word.length() == 0) return thisNode.hasWord;
      if (thisNode.children[word.charAt(0) - 'a'] == null) return false;
      return searchHelper(word.substring(1), thisNode.children[word.charAt(0) - 'a']);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      return startsWithHelper(prefix, root);
    }
    private boolean startsWithHelper(String prefix, TrieNode thisNode) {
      if (prefix.length() == 0) return true;
      if (thisNode.children[prefix.charAt(0) - 'a'] == null) return false;
      return startsWithHelper(prefix.substring(1), thisNode.children[prefix.charAt(0) - 'a']);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
