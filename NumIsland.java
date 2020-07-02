import java.util.LinkedList;
import java.util.Queue;

public class NumIsland{
  private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

  public int NumIslands(char[][] grid){
    Queue<int[]> q = new LinkedList();
    int count = 0;
    for(int row=0; row<grid.length; row++){
      for(int col=0; col<grid[0].length; col++){
        if(grid[row][col]=='1'){
          count++;
          grid[row][col] = 'v';
          q.add(new int[]{row,col});
          while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int[] direction : directions){
              int r = tmp[0]+direction[0];
              int c = tmp[1]+direction[1];
              if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]=='v'||grid[r][c]=='0'){
                continue;
              }
              grid[r][c]='v';
              q.add(new int[]{r,c});
            }
          }
        }
      }
    }
    return count;
  }
}
