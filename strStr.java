public class strStr{
  public static int strStr(String haystack, String needle){
    String[] tmp = haystack.split("");
    String[] array = new String[haystack.length()-(needle.length()-1)];

    if(haystack.length()<needle.length()){
      return -1;
    }
    else if(haystack.length()==needle.length()){
      if(haystack.equals(needle)){
        return 0;
      }
      else{
        return -1;
      }
    }
    else{
      for(int i=0; i<array.length; i++){
        array[i]=tmp[i]+tmp[i+1];
      }

      for(int i=0; i<array.length; i++){
        if(array[i].equals(needle)){
          return i;
        }
      }

    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(strStr("hello","ll"));
    System.out.println(strStr("aaaaa","bba"));
    System.out.println(strStr("a","a"));
    System.out.println(strStr("","a"));
    System.out.println(strStr("aa","aaa"));
  }
}
