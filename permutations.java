public class permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList();
    List<Integer> curr = new ArrayList();
    int[] array = new int[nums.length];
    for(int i=0;i<array.length;i++){
      array[i]=1;
    }
    helper(nums,ans,curr,0,array);
    return ans;
  }
  public void helper(int[] list, List<List<Integer>> memo, List<Integer> curr, int level,int[] array){
    if(level>list.length-1){
      memo.add(new ArrayList<Integer>(curr));
      return;
    }
    for(int i=0;i<list.length;i++){
      if(array[i]==0){
        continue;
      }else{
        curr.add(list[i]);
        array[i] = 0;
        helper(list,memo,curr,level+1,array);
        array[i] = 1;
        curr.remove(curr.size()-1);
      }
    }
  }
}
