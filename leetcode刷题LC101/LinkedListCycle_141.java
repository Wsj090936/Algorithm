package algorithms;
/* 
 *  Given a linked list, determine if it has a cycle in it.

	Follow up:
	Can you solve it without using extra space?
	
	判断一个链表中是否有环
 */
public class LinkedListCycle_141 {
    public static boolean hasCycle(ListNode head) {
        ListNode ptr = head;//快指针
        ListNode atr = head;//慢指针
        while(ptr != null){
            ptr = ptr.next;
            atr = atr.next;
            if(ptr == null)
                return false;
            ptr = ptr.next;
            if(ptr == atr){
                return true;
            }
        }
        return false;
    }
}
