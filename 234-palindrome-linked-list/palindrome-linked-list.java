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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st=new Stack<>();
        ListNode tmp=head;
        while(tmp!=null){
            st.push(tmp.val);
            tmp=tmp.next;
        }
        while(head!=null){
            if(head.val!=st.pop()){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}