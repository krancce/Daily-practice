class WordDictionary {

  public static class TrieNode{
    boolean isEnd;
    TrieNode[] children = new TrieNode[26];
  }
  TrieNode root;
  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode curr = root;
    for(char ch:word.toCharArray()){
      int index = ch-'a';
      if(curr.children[index]==null){
        curr.children[index] = new TrieNode();
      }
      curr = curr.children[index];
    }
    curr.isEnd = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return helper(word,0,root);

  }
  public boolean helper(String word, int index, TrieNode curr){
    if(index==word.length() && curr.isEnd==false){return false;}
    if(index==word.length() && curr.isEnd==true){return true;}
    char ch = word.charAt(index);
    if(ch=='.'){
      for(TrieNode tmp : curr.children){
        if(tmp!=null){
          boolean overall =  helper(word,index+1,tmp);
          if(overall){
            return true;
          }
        }

      }
    }else{
      int position = ch-'a';
      if(curr.children[position]!=null){
        boolean overall =  helper(word,index+1,curr.children[position]);
        if(overall){
          return true;
        }
      }
    }
    return false;
  }
}

/**
* Your WordDictionary object will be instantiated and called as such:
* WordDictionary obj = new WordDictionary();
* obj.addWord(word);
* boolean param_2 = obj.search(word);
*/
