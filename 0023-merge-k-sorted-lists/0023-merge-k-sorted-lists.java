/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(-1,null);
        ListNode temp=dummy;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                temp.next=head1;
                head1=head1.next;
            }else{
                temp.next=head2;
                head2=head2.next;
            }
            temp=temp.next;
        }
        if(head1!=null){
            temp.next=head1;
        }else if(head2!=null){
            temp.next=head2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        ListNode head=lists[0];
        int i=1;
        while(i<lists.length){
            head=merge(head,lists[i]);
            i++;
        }
        return head;
        
    }
}