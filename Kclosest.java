import java.util.Arrays;

class Kclosest {
    public static int[][] kClosest(int[][] points, int K) {
      int[] array = new int[points.length];
      for(int i=0;i<points.length;i++){
        array[i] = dist(points[i]);
      }
      Arrays.sort(array);
      int sol = array[K-1];
      int[][] solution = new int[K][2];
      int count = 0;
      for(int i=0;i<points.length;i++){
        if(dist(points[i])<=sol){
          solution[count] = points[i];
          count++;
        }
      }
      return solution;
    }

    public int dist(int[] point){
      return point[0]*point[0]+point[1]*point[1];
    }

}
