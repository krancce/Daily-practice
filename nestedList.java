public class nestedList{
  public int depthSumInverse(List<NestedInteger> nestedList) {
    return helper(nestedList,0);
  }

  public int helper(List<NestedInteger> root, int total){
    int sum = total;
    List<NestedInteger> tmp = new ArrayList();
    for(NestedInteger ni : root){
      if(ni.isInteger()){
        sum += ni.getInteger();
      }else{
        tmp.addAll(ni.getList());
      }
    }
    int listsum = tmp.size()==0? 0:helper(tmp,sum);
    return sum+listsum;
  }
}
