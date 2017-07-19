package algorithms;
/**
 * Remove all elements from a linked list of integers that have value val.

	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5
	
	Credits:
	Special thanks to @mithmatt for adding this problem and creating all test cases.
 * @author wushijia
 *
 */
public class Remove_Linked_List_Elements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode cur = node;
        ListNode ptr = head;
        while(ptr != null){
            if(ptr.val == val){
                cur.next = ptr.next;
            }else{
                cur = cur.next;
            }
            ptr = ptr.next;
        }
        return node.next;
    }
}
