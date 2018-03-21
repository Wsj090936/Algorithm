package linkedList;
/**
 * 打印两个有序链表的公共部分
 * @author wushijia
 *
 */
public class PrintLinkedList_samepart {
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
	}
	public static void printSame(Node head,Node head1){
		if(head == null || head1 == null){
			return;
		}
		Node ptr = head;
		Node cur = head1;
		while(ptr != null && cur != null){
			if(ptr.value == cur.value){
				System.out.println(ptr.value);
				ptr = ptr.next;
				cur = cur.next;
			}else{//谁小动谁
				ptr = ptr.value > cur.value ? ptr : ptr.next;
				cur = cur.value > ptr.value ? cur : cur.next;
			}
		}
	}
}
