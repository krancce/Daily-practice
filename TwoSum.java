import java.util.HashMap;
public class TwoSum{
  public static int[] twoSum(int[] nums, int target){
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0; i<nums.length; i++){
      map.put(target-nums[i],nums[i]);
      if(map.containsKey(nums[i])&&map.containsKey(target-nums[i])){
        for(int x=0; x<nums.length; x++){
          if(nums[x]==target-nums[i]){
            return new int[]{x,i};
          }
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void main(String[] args) {
    int[] tmp = new int[]{3,5,7,8};
    int[] sol = new int[2];
    sol=twoSum(tmp,11);
    System.out.println("[ "+sol[0]+" , "+sol[1]+" ]");
  }
}
