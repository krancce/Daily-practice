public class addbinary{
  public static String addbinary(String a, String b){
    int carry = 0;
    char[] first = a.toCharArray();
    char[] second = b.toCharArray();
    if(first.length<second.length){
      first = b.toCharArray();
      second = a.toCharArray();
    }
    char[] solution = new char[first.length+1];
    for(int i=1; i<=first.length; i++){
      if(i<=second.length){
        if(first[first.length-i]=='1'&second[second.length-i]=='1'&carry==1){
          solution[solution.length-i]='1';
        }else if((first[first.length-i]=='0'&second[second.length-i]=='1'&carry==1)||(first[first.length-i]=='1'&second[second.length-i]=='0'&carry==1)||(first[first.length-i]=='1'&second[second.length-i]=='1'&carry==0)){
          solution[solution.length-i]='0';
          carry=1;
        }else if(first[first.length-i]=='0'&second[second.length-i]=='0'&carry==0){
          solution[solution.length-i]='0';
        }else{
          solution[solution.length-i]='1';
          carry=0;
        }
      }else{
        if((carry==1&first[first.length-i]=='1')||(carry==0&first[first.length-i]=='0')){
          solution[solution.length-i]='0';
        }else{
          solution[solution.length-i]='1';
          carry=0;
        }
      }
    }
    if(carry==1){
      solution[0]='1';
    }else{
      char[] tmp = new char[solution.length-1];
      for(int i=0; i<tmp.length; i++){
        tmp[i]=solution[i+1];
      }
      solution=tmp;
    }
    String answer = new String(solution);
    System.out.println(answer);
    return answer;
  }

  public static void main(String[] args) {
    String a ="1";
    String b ="1";
    addbinary(a,b);
  }
}
