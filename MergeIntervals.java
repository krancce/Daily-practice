import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {

      Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0],arr2[0]));

      if(intervals.length<=1){
        return intervals;
      }
      ArrayList<int[]> out_list = new ArrayList();
      int[] current_interval = intervals[0];
      out_list.add(current_interval);

      for(int[] interval: intervals){
        int current_begin = current_interval[0];
        int current_end = current_interval[1];
        int next_begin = interval[0];
        int next_end = interval[1];

        if(current_end>=next_begin){
          current_interval[1] = Math.max(current_end,next_end);
        }else{
          out_list.add(interval);
          current_interval=interval;
        }
      }

      return out_list.toArray(new int[out_list.size()][2]);
    }

    public static void main(String[] args) {
      int[][] tada = {{2,3},{4,5},{6,7},{8,9},{1,10}};
      System.out.println(Arrays.deepToString(merge(tada)));
    }
}
