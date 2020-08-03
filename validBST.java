public class validBST{
  public boolean isValidBST(TreeNode root) {
    if(root==null){return true;}
    HashSet<TreeNode> visited = new HashSet();
    Stack<Integer> list = new Stack();
    Stack<TreeNode> s = new Stack();
    s.push(root);
    while(!s.isEmpty()){
      TreeNode curr = s.peek();
      if(curr.left!=null && !visited.contains(curr.left)){
        s.push(curr.left);
        visited.add(curr.left);
      }else{
        if(!list.isEmpty() && list.peek()>=curr.val){return false;}
        list.push(curr.val);
        curr = s.pop();
        if(curr.right!=null){
          s.push(curr.right);
        }
      }
    }
    return true;
  }
}
