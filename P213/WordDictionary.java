class WordDictionary {
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
    public WordDictionary() {
      root = new TrieNode('0');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
      return searchHelper(word, root);
    }
    private boolean searchHelper(String word, TrieNode thisNode) {
      if (thisNode == null) return false;
      if (word.length() == 0) return thisNode.hasWord;
      char c = word.charAt(0);
      if (c == '.') {
        for (int i = 0; i < 26; i++) {
          if (searchHelper(word.substring(1), thisNode.children[i])) return true;
        }
        return false;
      }
      if (thisNode.children[word.charAt(0) - 'a'] == null) return false;
      return searchHelper(word.substring(1), thisNode.children[word.charAt(0) - 'a']);
    }


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
