/**
* // This is the BinaryMatrix's API interface.
* // You should not implement it, or speculate about its implementation
* interface BinaryMatrix {
*     public int get(int row, int col) {}
*     public List<Integer> dimensions {}
* };
*/

class leftOne {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> dim = binaryMatrix.dimensions();
    int Row = dim.get(0);
    int Col = dim.get(1);
    int row = 0;
    int col =Col-1;
    int last = -1;
    while(col>=0 && row<Row){
      int curr = binaryMatrix.get(row,col);
      if(curr==1){
        last = col;
        col--;
      }else if(curr==0){
        row++;
      }
    }
    return last;
  }
}
