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
    public int length(ListNode head)
    {
        int count=0;
        ListNode current=head;
        if(head==null)
            return 0;
        while(current!=null)
        {
            count=count+1;
            current=current.next;
        }
        return count;
    }
   public ListNode res=null;
    public ListNode tail=null;
    public void insert(int n)
    {
        ListNode node=new ListNode(n);
        if(res==null)
        {
            res=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=node;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        int i=length(head);
        if(k>=i)
        {
            k=k%i;
        }
        if(k==0)
            return head;
        while(k>0 && fast!=null)
        {
            fast=fast.next;
            k--;
        }
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        ListNode pre=slow.next;
        slow.next=null;
        while(pre!=null)
        {
            insert(pre.val);
            pre=pre.next;
        }
        tail.next=head;
        return res;        
}
}
