import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BSTlevelordertraversal {

  public static class Node{
    int value;
    Node left, right;
    public Node(int value, Node left, Node right){
      this.left = left;
      this.right = right;
      this.value = value;
    }
  }
  public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
    ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
    Queue<Node> queue = new LinkedList();
    queue.offer(root);
    if(root==null){
      return solution;
    }
    while(!queue.isEmpty()){
      int level = queue.size();
      ArrayList<Integer> tmp = new ArrayList<Integer>();
      for(int i=0; i<level; i++){
        Node node = queue.poll();
        tmp.add(node.value);
        if(node.left!=null){
          queue.offer(node.left);
        }
        if(node.right!=null){
          queue.offer(node.right);
        }
      }
      solution.add(tmp);
    }
    return solution;
  }

}
