package algorithms2;
/**
 * 先将链表拆分成两个链表，然后组装起来
 * @author wushijia
 *
 */
public class Relocate {
	public void fun1(Node head){
		if(head == null){
			return;
		}
		Node mid = head;//中间节点。左边链表的尾部节点
		Node right = head.next;//右边链表的头结点
		while(right.next != null && right.next.next != null){
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mid.next = null;
		mergeLR(head, right);//开始合并两个链表
	}
	private void mergeLR(Node left,Node right){//合并两个链表
		Node next = null;
		while(left.next != null){
			next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
		}
		left.next = right;
	}
}
