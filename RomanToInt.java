import java.util.HashMap;
public class RomanToInt{
  public static int romanToInt(String s){

    HashMap<String,Integer> map=new HashMap<>();
    map.put("I",1);
    map.put("V",5);
    map.put("X",10);
    map.put("L",50);
    map.put("C",100);
    map.put("D",500);
    map.put("M",1000);

    char[] array = s.toCharArray();
    String[] list= new String[array.length];
    for(int i=0;i<list.length;i++){
      list[i]=String.valueOf(array[i]);
    }

    int x=0;
    for(int i=0; i<list.length-1; i++){
      if(map.get(list[i])>=map.get(list[i+1])){
        x=x+map.get(list[i]);
        if(i==list.length-2){
          return x+map.get(list[i+1]);
        }
      }
      else{
        x=x+map.get(list[i+1])-map.get(list[i]);
        if(i==list.length-2){
          return x;
        }
        else{
          i=i+1;
        }
      }
    }
    return x;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("XXVII"));
  }
}
