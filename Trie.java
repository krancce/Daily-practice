class Trie {
  static class TrieNode{
    private boolean isEnd;
    private TrieNode[] children = new TrieNode[26];
  }
  TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode curr = root;
    for(char ch : word.toCharArray()){
      int index = ch-'a';
      if(curr.children[index]==null){
        curr.children[index]=new TrieNode();
      }
      curr = curr.children[index];
    }
    curr.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode curr = root;
    for(char ch : word.toCharArray()){
      int index = ch-'a';
      if(curr.children[index]==null){return false;}
      curr = curr.children[index];
    }
    return curr.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for(char ch : prefix.toCharArray()){
      int index = ch-'a';
      if(curr.children[index]==null){return false;}
      curr = curr.children[index];
    }
    return true;
  }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/
