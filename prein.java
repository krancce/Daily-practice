public class prein{
  int[] preorder;
  int[] inorder;
  HashMap<Integer,Integer> map = new HashMap();
  int index;
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder.length==0){return null;}
    this.preorder = preorder;
    this.inorder = inorder;
    index = 0;
    for(int i=0;i<inorder.length;i++){
      map.put(inorder[i],i);
    }
    return helper(0,inorder.length-1);
  }
  public TreeNode helper(int left, int right){
    if(left>right){
      return null;
    }
    int val = preorder[index];
    TreeNode root = new TreeNode(val);
    int inIndex = map.get(val);
    index++;
    root.left = helper(left,inIndex-1);
    root.right = helper(inIndex+1,right);
    return root;
  }
}
