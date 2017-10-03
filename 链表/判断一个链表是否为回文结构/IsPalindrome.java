package algorithms;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * @author wushijia
 *
 */
public class IsPalindrome {
	public boolean fun1(Node head){//方法一，空间复杂度为O(N)
		if(head == null || head.next == null){
			return true;
		}
		Node right = head.next;
		Node cur = head;//快指针，用来帮助确定右半部分，如果链表长度为奇数，则舍弃最中间的节点
		while(cur.next != null && cur.next.next != null){//确定右半部分的头结点为right
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<>();
		while(right != null){
			stack.add(right);
			right = right.next;
		}
		while(!stack.isEmpty()){
			if(head.value != stack.pop().value){//当右半部分与左半部分不相同时
				return false;
			}
			head = head.next;
		}
		return true;
	}
	public boolean fun2(Node head){//方法二，空间复杂度为O(1)
		if(head == null || head.next == null){
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null){
			n1 = n1.next;//中间节点
			n2 = n2.next.next;//尾部节点
		}
		n2 = n1.next;//右半区第一个节点
		n1.next = null;//中间节点的下一个节点指向null
		Node n3 = null;
		while(n2 != null){//反转右半区
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;//n1移动
			n2 = n3;//n2移动
		}
		n2 = head;//左边第一个节点
		n3 = n1;//保存最后一个节点
		boolean res = true;
		while(n2 != null && n1 != null){//开始比较
			if(n2.value != n1.value){
				res = false;
				break;
			}
			n2 = n2.next;
			n1 = n1.next;
		}
		//恢复链表
		n1 = n3.next;
		n3.next = null;//最后一个节点
		while(n1 != null){
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
}
