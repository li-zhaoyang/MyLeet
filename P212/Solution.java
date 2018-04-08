import java.util.*;
class Solution {
  class Trie {
      class TrieNode {
        public char val;
        public TrieNode[] children;
        public boolean hasWord;
        public TrieNode(char c) {
          val = c;
          children = new TrieNode[26];
          hasWord = false;
        }
      }
      public TrieNode root;
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
    public List<String> findWords(char[][] board, String[] words) {
      HashSet<String> ans = new HashSet<String>();
      if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0) return new ArrayList<String>(ans);
      Trie trie = new Trie();
      for (String word: words) {
        trie.insert(word);
      }
      int m = board.length, n = board[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          searchHelper(i, j, m, n, trie.root, board, new HashSet<Integer>(), new LinkedList<Character>(), ans);
        }
      }
      return new ArrayList<String>(ans);
    }

    private void searchHelper(int i, int j, int m, int n, Trie.TrieNode trieNode, char[][] board, HashSet<Integer> searched, LinkedList<Character> temp, HashSet<String> ans) {
      if (i < 0 || i >= m || j < 0 || j >= n) return;
      if (searched.contains(i * n + j)) return;
      searched.add(i * n + j);
      if (trieNode.children[board[i][j] - 'a'] == null) return ;
      temp.add(board[i][j]);
      if (trieNode.children[board[i][j] - 'a'].hasWord) {
        char[] charArray = new char[temp.size()];
        for (int k = 0; k < temp.size(); k++) {
          charArray[k] = temp.get(k);
        }
        ans.add(new String(charArray));
      }
      searchHelper(i + 1, j, m, n, trieNode.children[board[i][j] - 'a'], board, new HashSet<Integer>(searched), temp, ans);
      searchHelper(i - 1, j, m, n, trieNode.children[board[i][j] - 'a'], board, new HashSet<Integer>(searched), temp, ans);
      searchHelper(i, j + 1, m, n, trieNode.children[board[i][j] - 'a'], board, new HashSet<Integer>(searched), temp, ans);
      searchHelper(i, j - 1, m, n, trieNode.children[board[i][j] - 'a'], board, new HashSet<Integer>(searched), temp, ans);
      temp.removeLast();
    }
}
