import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates{

  private static final int EMPTY = Integer.MAX_VALUE;
  private static final int GATE = 0;
  private static final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};

  public void WallsAndGates(in[][] rooms){
    int r = rooms.length;
    if(r==0){return;}
    int c = rooms[0].length;
    Queue<int[]> queue = new LinkedList();
    for(int rwo=0; row<r; row++){
      for(int col=0; col<c; col++){
        if(rooms[row][col]==GATE){
          queue.add(new int[]{row,col});
        }
      }
    }

    while(!queue.isEmpty()){
      int[] tmp = queue.poll();
      for(int[] direction : DIRECTIONS){
        int newRow = tmp[0]+direction[0];
        int newCol = tmp[1]+direction[1];
        if(newRow<0||newCol<0||newRow>=r||newCol>=c||rooms[newRow][newCol]!=EMPTY){
          continue;
        }
        rooms[newRow][newCol] = rooms[tmp[0]][tmp[1]]+1;
        queue.add(new int[]{newRow,newCol});
      }
    }
  }
}
