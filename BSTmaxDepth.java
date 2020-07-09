class BSTmaxDepth {
  public int maxDepth(TreeNode root) {
    if(root==null){
      return 0;
    }
    Stack<Pair<TreeNode,Integer>> s = new Stack();
    s.push(new Pair<>(root,1));
    int max = 1;
    while(!s.isEmpty()){
      Pair<TreeNode,Integer> curr = s.pop();
      TreeNode node = curr.getKey();
      int cur_depth = curr.getValue();
      if(node.left!=null){
        s.push(new Pair<>(node.left,cur_depth+1));
      }
      if(node.right!=null){
        s.push(new Pair<>(node.right,cur_depth+1));
      }
      max = Math.max(max,curr.getValue());
    }
    return max;
  }
}
