import java.util.Arrays;
public class mergeArray{
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if(m==0){
      nums1=nums2;
      System.out.println(Arrays.toString(nums1));
    }else if(nums2.length==0){
      System.out.println(Arrays.toString(nums1));
    }else{
      boolean empty = false;
      int index = nums1.length-1;
      while(empty==false){
        if(index==0){
          nums1[0]=nums2[0];
          empty=true;
        }else if(m==0){
          nums1[index]=nums2[n-1];
          n--;
          index--;
        }else if(nums2[n-1]>=nums1[m-1]){
          nums1[index]=nums2[n-1];
          n--;
          index--;
          if(n==0){
            empty=true;
          }
        }else{
            nums1[index]=nums1[m-1];
            m--;
            index--;
        }
      }
      System.out.println(Arrays.toString(nums1));
    }
  }

  public static void main(String[] args) {
    int[] nums1 = {0};
    int[] nums2 = {1};
    merge(nums1,0,nums2,1);
  }
}
