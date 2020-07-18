import java.util.PriorityQueue;
import java.util.Comparator;

public class point {
  public int[][] kClosest(int[][] points, int K){
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new distanceComparator());
    for(int i=0;i<points.length;i++){
      pq.offer(points[i]);
    }
    int[][] ans = new int[K][2];
    for(int i=0;i<K;i++){
      ans[i] = pq.poll();
    }
    return ans;
  }

  public class distanceComparator implements Comparator<int[]>{
    public int compare(int[] x, int[] y){
      if((x[1]*x[1]+x[0]*x[0])<(y[1]*y[1]+y[0]*y[0])){
        return -1;
      }else if((x[1]*x[1]+x[0]*x[0])>(y[1]*y[1]+y[0]*y[0])){
        return 1;
      }else{
        return 0;
      }
    }
  }

}
