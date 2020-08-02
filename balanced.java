public class balanced{
  public boolean isBalanced(TreeNode root){
    if(root==null){return ture;}
    int left = getHeight(root.left);
    int right = getHeight(root.right);

    return Math.abs(left-right)<2 && isBalanced(root.left) && isBalanced(root.right);
  }

  public int getHeight(TreeNode){
    if(root==null){return -1;}
    int level = 1 + Math.max(getHeight(root.left),getHeight(root.right));
    return level;
  }
}
