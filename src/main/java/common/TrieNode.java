package common;

/** Trie data structure for storing words. */
public class TrieNode {
  String word;
  TrieNode[] children;

  public TrieNode() {
    // If this is the last node of the Trie, word = item, else it is null
    word = null;
    // assuming only 26 characters all lowercase.
    children = new TrieNode[26];
  }

  boolean search(String word) {
    TrieNode pCraw = this;
    for (char c : word.toCharArray()) {
      if (pCraw.children[c - 'a'] == null) return false;
      pCraw = pCraw.children[c - 'a'];
    }
    return word.equals(pCraw.word);
  }

  void insert(String word) {
    TrieNode pCraw = this;
    for (char c : word.toCharArray()) {
      if (pCraw.children[c - 'a'] == null) {
        pCraw.children[c - 'a'] = new TrieNode();
      }
      pCraw = pCraw.children[c - 'a'];
    }
    pCraw.word = word;
  }

  void insert(String[] words) {
    for (String word : words) insert(word);
  }
}
