package algorithms2;

import java.util.Stack;

/**
 * 将一个链表中，每K个节点逆序 如：1->2->3->4->5->6->7->8->null 变为 3->2->1-:6->5->4->7->8->null
 * 
 * @author wushijia
 *
 */
public class ReverseKNodes {
	private Node resign(Stack<Node> stack,Node left,Node right){//left为左边链表的最后一个节点，right为右边元素的第一个节点
		Node cur = stack.pop();
		if(left != null){
			left.next = cur;
		}
		Node next = null;
		while(!stack.isEmpty()){
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;//反转后的链表与原来的链表相连接起来
		return cur;
	}
	public Node fun1(Node head,int K){
		if(head == null){
			return null;
		}
		if(K < 2){
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		Node newHead = head;
		Node cur = head;//指针节点
		Node next = null;
		Node pre = null;//翻转后链表的最后一个节点
		while(cur != null){
			next = cur.next;
			stack.push(cur);
			if(stack.size() == K){
				pre = resign(stack,pre,next);
				newHead = newHead == head ? cur : newHead;//在第一次反转链表时将头结点确定，以后就不会改变了
			}
			cur = next;
		}
		return newHead;
	}
}
