public class preorder{
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList();
    if(root==null){return ans;}
    HashSet<TreeNode> visited = new HashSet();
    Stack<TreeNode> s = new Stack();
    s.push(root);
    while(!s.isEmpty()){
      TreeNode curr = s.peek();
      if(!visited.contains(curr)){
        visited.add(curr);
        ans.add(curr.val);
      }
      if(curr.left!=null && !visited.contains(curr.left)){
        s.push(curr.left);
      }else{
        if(curr.right!=null && !visited.contains(curr.right)){
          s.push(curr.right);
        }else{
          s.pop();
        }
      }
    }
    return ans;
  }
}
