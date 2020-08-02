public class pre{
  int[] preorder;
  int index = 0;
  int n;
  public TreeNode bstFromPreorder(int[] preorder) {
    this.preorder = preorder;
    n = preorder.length;
    return helper(Integer.MIN_VALUE,Integer.MAX_VALUE);
  }
  public TreeNode helper(int min, int max){
    if(index==n){return null;}
    int val = preorder[index];
    if(val>max||val<min){return null;}
    index++;
    TreeNode root = new TreeNode(val);
    root.left = helper(min,val);
    root.right = helper(val,max);
    return root;
  }
}
