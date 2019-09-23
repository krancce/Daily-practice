import java.util.HashMap;
public class twoSum{
  public static int[] twosum(int[] nums, int target){
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] { map.get(complement), i };
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void main(String[] args) {
    int[] tmp = new int[]{3,5,7,8};
    int[] sol = new int[2];
    sol=twosum(tmp,11);
    System.out.println("[ "+sol[0]+" , "+sol[1]+" ]");
  }
}
