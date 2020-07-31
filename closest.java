public class closest{
  public int closestValue(TreeNode root,double target){
    int currValue;
    int closestValue = root.value;
    while(root!=null){
      currValue = root.val;
      closestValue = Math.abs(currValue-target)<Math.abs(closestValue-target)? currValue:closestValue;
      root = target<currValue? root.left:root.right;
    }
    return closestValue;
  }
}
