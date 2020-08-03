public class mergeSorted{
  public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    ListNode ans = new ListNode(0);
    ListNode pointer = ans;
    while(l1!=null&&l2!=null){
      if(l1.val<=l2.val){
        pointer.next = new ListNode(l1.val);
        pointer = pointer.next;
        l1 = l1.next;
      }else{
        pointer.next = new ListNode(l2.val);
        pointer = pointer.next;
        l2 = l2.next;
      }
    }
    pointer.next = (l1==null)? l2:l1;
    return ans.next;
  }
}
