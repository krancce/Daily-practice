class wordDictionary {
    HashMap<Integer,ArrayList<String>> dic;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.dic = new HashMap<Integer,ArrayList<String>>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(this.dic.containsKey(word.length())){
            this.dic.get(word.length()).add(word);
        }else{
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.add(word);
            this.dic.put(word.length(),tmp);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(!this.dic.containsKey(word.length())){
            return false;
        }else{
            ArrayList<String> tmp = this.dic.get(word.length());
            if(tmp.contains(word)){
                return true;
            }else{
                OUTTERLOOP:for(int i=0;i<tmp.size();i++){
                    int index = 0;
                    for(char ch:word.toCharArray()){
                        if(ch!='.'&&ch!=tmp.get(i).charAt(index)){
                            continue OUTTERLOOP;
                        }
                        index++;
                    }
                    return true;
                }
                return false;
            }
        }
    }
}
