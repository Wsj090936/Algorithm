package linkedList;
/**
 * 两个链表相交的一系列问题
 * @author wushijia
 *一个链表有环  另一个无环，则必然他们不想交，若两个链表都有环，则他们可能相交  也可能不想交
 */
public class TwoLinkedList_xiangjiao {
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
	}

	public Node noLoop(Node head1,Node head2){//l两个无环链表是否相交，若相交，返回第一个相交节点
		if(head1 == null || head2 == null){//也可以使用HashSet
			return null;
		}
		int len = 0;
		Node cur = head1;
		Node ptr = head2;
		while(cur.next != null){//得到链表一的长度
			len++;
			cur = cur.next;
		}
		while(ptr.next != null){
			len--;
			ptr = ptr.next;
		}
		if(cur != ptr){//若不相交
			return null;
		}
		cur = len > 0 ? head1 : head2;//cur始终是长的那条链表的头节点
		ptr = cur == head1 ? head2 : head1;
		len = Math.abs(len);//取len的绝对值
		while(len != 0){
			len--;
			cur = cur.next;
		}
		//到了这一步后，cur和ptr到相交第一个节点的距离就相等了
		while(cur != ptr){
			cur = cur.next;
			ptr = ptr.next;
		}
		return cur;
	}
	
	public Node getLoopNode(Node head){//判断一个链表是否有环，有环则返回第一个入环节点，否则返回null
		if(head == null){
			return null;
		}
		Node slow = head.next;
		Node fast = head.next.next;
		while(slow != fast){
			if(fast.next == null || fast.next.next == null){
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
