import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class threesum{
  public static ArrayList<ArrayList<Integer>> threesum(int[] nums, int target){
    ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();

    for(int i=0; i<nums.length; i++){
      int twosum = target-nums[i];
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int x=i+1; x<nums.length; x++){
        int complement = twosum-nums[x];
        if(map.containsKey(complement)){
          int[] tmp = {complement, nums[x], nums[i]};
          Arrays.sort(tmp);
          ArrayList<Integer> list = new ArrayList<Integer>();
          list.add(tmp[0]);
          list.add(tmp[1]);
          list.add(tmp[2]);
          if(!solution.contains(list)){
            solution.add(list);
          }
          map.put(nums[x],x);
        }else{
          map.put(nums[x],x);
        }
      }
    }
    return solution;
  }

  public static void main(String[] args) {
    int[] array = {-1,0,1,2,-1,-4};
    ArrayList<ArrayList<Integer>> sol = threesum(array,0);
    System.out.println("[");
    for(int i=0; i<sol.size(); i++){
      System.out.println(Arrays.toString(sol.get(i).toArray()));
    }
    System.out.println("]");
  }
}
