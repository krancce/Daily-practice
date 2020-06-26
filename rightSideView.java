import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class rightSideView{

  public static class Treenode{
    int val;
    Treenode right;
    Treenode left;
    Treenode(int val,Treenode right,Treenode left){
      this.val = val;
      this.right = right;
      this.left = left;
    }
  }

  public static ArrayList<Integer> rightSideView(Treenode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    Queue<Treenode> queue = new LinkedList<Treenode>();
    if (root == null) return result;

    queue.offer(root);
    while (queue.size() != 0) {
      int size = queue.size();
      for (int i=0; i<size; i++) {
        Treenode cur = queue.poll();
        if (i == 0) result.add(cur.val);
        if (cur.right != null) queue.offer(cur.right);
        if (cur.left != null) queue.offer(cur.left);
      }

    }
    return result;
  }

  public static void main(String[] args) {
    Treenode root = new Treenode(1,null,null);
    root.left = new Treenode(2,null,null);
    root.right = new Treenode(3,null,null);
    root.left.left = new Treenode(4,null,null);
    ArrayList<Integer> ans = new ArrayList<Integer>();
    ans = rightSideView(root);
    for(int i=0; i<ans.size(); i++){
      System.out.println(ans.get(i));
    }
  }
}
