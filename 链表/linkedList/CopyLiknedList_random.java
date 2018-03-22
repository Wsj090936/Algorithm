package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 拷贝一个单链表，但是该单链表的每一个节点有一个随机的指针指向任意节点
 * @author wushijia
 *
 */
public class CopyLiknedList_random {
	public class Node{
		public int value;
		public Node next;
		public Node rand;
		public Node(int value){
			this.value = value;
		}
	}
	public Node CopyLinkedListRand(Node head){//方法一  空间复杂度为O(n)
		if(head == null){
			return null;
		}
		Map<Node,Node> map = new HashMap<>();
		Node cur = head;
		while(cur != null){//将节点和复制节点全部放入哈希表
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		Node ptr = head;
		while(ptr != null){//遍历map组合克隆节点
			map.get(ptr).next = map.get(ptr.next);
			map.get(ptr).rand = map.get(ptr.rand);
			ptr = ptr.next;
		}
		return map.get(head);
	}
	public Node CopyLinkedListRan(Node head){//方法二：空间复杂度为O(1)
		if(head == null){
			return null;
		}
		Node next = null;
		Node ptr = head;
		while(ptr != null){//将复制结点接在每一个原节点后面
			next = ptr.next;
			ptr.next = new Node(ptr.value);
			ptr.next.next = next;
			ptr = next;
		}
		ptr = head;
		Node copyNode = null;
		while(ptr != null){//将复制节点的rand指针指向
			next = ptr.next.next;
			copyNode = ptr.next;
			copyNode.rand = ptr.rand==null?ptr.rand.next:null;//根据是否为空来指向
			ptr = next;
		}
		Node copyHead = head.next;
		ptr = head;
		while(ptr != null){
			next = ptr.next.next;
			copyNode = ptr.next;
			ptr.next = next;
			copyNode.next = next == null?null:next.next;
			ptr = next;
		}
		return copyHead;
	}
}
