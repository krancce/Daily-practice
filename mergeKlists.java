public class mergeKlists{

  private static class Node{
    private int value;
    private Node next;
    private Node(int value, Node next){
      this.value = value;
      this.next = next;
    }
  }

  public static Node mergeKlists(Node[] lists){
    Node tmp;
    int index = 0;
    Node solution = null;
    Node pointer = null;

    while(lists.length != 0){
      tmp = lists[0];
      for(int i=0; i<lists.length; i++){
        if(tmp.value>=lists[i].value){
          tmp = lists[i];
          index = i;
        }
      }
      // find the minimum number in minheap;
      if(solution == null){
        solution = tmp;
        pointer = solution;
      }else{
        pointer.next = tmp;
        pointer = pointer.next;
      }
      // check if solution node is null & assign value to solution node;
      if(lists[index].next == null){
        if(lists.length == 1){
          return solution;
          // check if it is the last node of all the lists
        }else{
          Node[] x = new Node[lists.length-1];
          for(int i=0; i<x.length; i++){
            if(i >= index){
              x[i] = lists[i+1];
            }else{
              x[i] = lists[i];
            }
          }
          lists = x;
        }

      }else{
        lists[index] = lists[index].next;
      }
      // check if the minheap is minimized;
    }
    // keep looping while the lists is not empty;
    return solution;
  }

  public static void main(String[] args) {
    Node test1 = new Node(1,null);
    test1.next=new Node(4,null);
    test1.next.next=new Node(5,null);
    Node test2 = new Node(1,null);
    test2.next = new Node(3,null);
    test2.next.next = new Node(4,null);
    Node test3 = new Node(2,null);
    test3.next = new Node(6,null);
    Node[] testlist = {test1,test2,test3};
    Node pointers = mergeKlists(testlist);
    while(pointers != null){
      System.out.println(pointers.value);
      pointers=pointers.next;
    }
  }


}
