class DecodeWays{
  public int Decode(String s) {
    char[] array = s.toCharArray();
    int[] memo = new int[array.length+1];
    int restLength = array.length;
    return Decode_DP(array,restLength,memo);
  }

  public int Decode_DP(char[] array, int restLength, int[] memo){
    if(restLength==0) return 1;
    if(array[array.length-restLength]=='0')return 0;
    if(memo[restLength]!=0)return memo[restLength];
    int result = Decode_DP(array,restLength-1,memo);
    if(restLength>=2 && Character.getNumericValue(array[array.length-restLength])*10+Character.getNumericValue(array[array.length-restLength+1])<=26){
      result += Decode_DP(array,restLength-2,memo);
    }
    memo[restLength] = result;
    return result;
  }
}
