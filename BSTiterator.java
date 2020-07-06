public class BSTiterator{
  ArrayList<Integer> nodesVal;
  int count;

  public BSTIterator(TreeNode root) {
    this.nodesVal = new ArrayList<Integer>();
    this.count = -1;
    helper(root);
  }

  private void helper(TreeNode root){
    if(root==null){
      return;
    }
    helper(root.left);
    this.nodesVal.add(root.val);
    helper(root.right);
  }

  /** @return the next smallest number */
  public int next() {
    return this.nodesVal.get(++this.count);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return this.count+1<this.nodesVal.size();
  }
}
