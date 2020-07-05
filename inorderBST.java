public class inorderBST{
  HashSet<TreeNode> visited = new HashSet();
    Stack<TreeNode> s = new Stack();
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null){return list;}
        s.push(root);
        while(!s.isEmpty()){
            if(s.peek().left!=null&&!visited.contains(s.peek().left)){
                s.push(s.peek().left);
            }
            else{
                TreeNode tmp = s.pop();
                visited.add(tmp);
                list.add(tmp.val);
                if(tmp.right!=null){
                    s.push(tmp.right);
                }

            }
        }
        return list;
    }
}
