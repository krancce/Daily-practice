import java.util.Stack;
 public class RemoveDuplicatesSorted{
   public static int removeDuplicates(int[] nums){
     Stack<Integer> stack = new Stack<Integer>();
     for(int i=0; i<nums.length; i++){
       if(stack.empty()){
         stack.push(nums[i]);
       }
       if(nums[i]!=stack.peek()){
         stack.push(nums[i]);
       }
     }
     return stack.search(nums[0]);
   }

   public static void main(String[] args) {
     int[] tmp1 = {1,1,2,3,3,4,5,5};
     int[] tmp2 = {1,2,3,4};
     System.out.println(removeDuplicates(tmp1));
     System.out.println(removeDuplicates(tmp2));
   }
 }
