package algorithms;
/*
 * 
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
   思路:题中给出了一个单链表，要求我们删除倒数第k个结点，首先，我们先将k从头结点开始，定义一个游标结点ptr开始时指向头节点，每经过一个结点就另k减一，直到遍历完链表
   然后，判断k的值，如果k为0，那么要删除的就是头节点，如果k大于0，那么要删除的结点不存在，如果k小于0，则令ptr指向头节点从头开始遍历链表，当ptr每移动一次，令k的
   值加一，当k为0的时候，停止移动，则此时ptr所在的位置就是要被删除的结点的前一个结点。
 */
public class RemoveNthNodeFromEndofList_19 {
	public ListNode1 removeNthFromEnd(ListNode1 head, int k) {
		if(head == null || k <1){
			return null;
		}
		ListNode1 ptr = head;//游标结点
		ListNode1 e = null;//用来存被删除的结点
		while(ptr != null){
			--k;
			ptr = ptr.next;
		}
		if(k == 0){//k==0时删除头节点
			e = head;
			head = head.next;
			return head;
		}else if(k > 0){//k>0表示要删除的结点不存在
			return head;
		}else{
			ptr = head;
			while(++k != 0){
				ptr = ptr.next;
			}
			e = ptr.next;
			ptr.next = ptr.next.next;
		}
		return head;
    }
}

class ListNode1 {
     int val;
     ListNode1 next;
     ListNode1(int x) { val = x; }
 }
