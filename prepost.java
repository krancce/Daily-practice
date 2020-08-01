public class prepost{
  HashMap<Integer,Integer> map = new HashMap();
  int[] pre;
  int[] post;
  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    if(pre.length==0){return null;}
    this.pre = pre;
    this.post = post;
    for(int i=0;i<post.length;i++){
      this.map.put(post[i],i);
    }
    return helper(0,pre.length-1,0,post.length-1);
  }
  public TreeNode helper(int pre_left, int pre_right, int post_left, int post_right){
    if(pre_left>pre_right){return null;}
    int val = pre[pre_left];
    TreeNode root = new TreeNode(val);
    if(pre_left==pre_right || post_left==post_right){
      return root;
    }
    int preVal = pre[pre_left+1];
    int postIndex = this.map.get(preVal);
    root.left = helper(pre_left+1,pre_left+1+postIndex-post_left,post_left,postIndex);
    root.right = helper(pre_left+2+postIndex-post_left,pre_right,postIndex+1,post_right-1);
    return root;
  }
}
