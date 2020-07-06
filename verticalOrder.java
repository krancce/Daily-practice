import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class verticalOrder{
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
    }
    public static ArrayList<ArrayList<Integer>> verticalOrder(TreeNode root) {
      if(root==null){
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        return ans;
      }
      HashMap<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
      Queue<TreeNode> q = new LinkedList();
      Queue<TreeNode> Q = new LinkedList();
      ArrayList<Integer> list = new ArrayList();
      q.offer(root);
      Q.offer(root);
      map.put(root,0);
      list.add(0);
      while(!q.isEmpty()){
        TreeNode curr = q.poll();
        if(curr.left!=null){
          q.offer(curr.left);
          Q.offer(curr.left);
          map.put(curr.left,map.get(curr)-1);
          if(!list.contains(map.get(curr)-1)){
            list.add(map.get(curr)-1);
          }
        }
        if(curr.right!=null){
          q.offer(curr.right);
          Q.offer(curr.right);
          map.put(curr.right,map.get(curr)+1);
          if(!list.contains(map.get(curr)+1)){
            list.add(map.get(curr)+1);
          }
        }
      }
      int[] tmp = new int[list.size()];
      for(int i=0;i<list.size();i++){
        tmp[i]=list.get(i);
      }
      Arrays.sort(tmp);
      ArrayList<Integer> rank = new ArrayList();
      for(int i=0;i<tmp.length;i++){
        rank.add(tmp[i]);
      }
      ArrayList<Integer>[] solution = new ArrayList[rank.size()];
      for(int i=0;i<rank.size();i++){
        ArrayList<Integer> a = new ArrayList();
        solution[i]=a;
      }
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      while(!Q.isEmpty()){
        TreeNode node = Q.poll();
        int pos = rank.indexOf(map.get(node));
        solution[pos].add(node.val);
      }
      for(int i=0;i<solution.length;i++){
        ans.add(solution[i]);
      }
      return ans;
    }
  }
