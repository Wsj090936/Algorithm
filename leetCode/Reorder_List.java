package leetCode;
/**
 *  Given a singly linked list L: L 0→L 1→…→L n-1→L n,
	reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
	
	You must do this in-place without altering the nodes' values.
	
	For example,
	Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * @author wushijia
 * 本题思路，首先先找到中间节点和最后节点(快慢指针即可)，然后将右半部分节点翻转过来，
 * 然后进行第i个节点和第n-i个节点的拼接(i从0开始)
 */
public class Reorder_List {
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
        	return;
        }
        ListNode slow = head;//位于链表中间
        ListNode fast = head;//位于链表末尾
    	while(fast.next != null && fast.next.next != null){
    		slow = slow.next;//中间的指针
    		fast = fast.next.next;
    	}
    	if(fast.next != null){
    		fast = fast.next;
    	}
    	//然后开始翻转另一半链表
    	ListNode pre = slow;
    	ListNode cur = pre.next;
    	ListNode next = null;
    	pre.next = null;
    	while(cur != null){//开始翻转
    		next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
        cur = head;
        ListNode ptr = fast;//右边链表的next指针
        next = null;
        while(cur != null){
        	next = cur.next;
        	ptr = fast.next;
        	cur.next = fast;
        	fast.next = next;
        	cur = next;
        	fast = ptr;
        }
        
    }
    private static void reverseHalfLinkedList(ListNode head){
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		reorderList(head);
		ListNode cur = head;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
		
	}
}
