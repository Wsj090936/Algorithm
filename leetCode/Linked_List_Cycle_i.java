package leetCode;
/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 * @author wushijia
 *判断一个链表是否有环
 */
public class Linked_List_Cycle_i {
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
        	return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast.next != null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast){
        		flag = true;
        		break;
        	}
        }
        return flag;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
//		head.next.next.next = head.next;
		System.out.println(hasCycle(head));
	}
}
