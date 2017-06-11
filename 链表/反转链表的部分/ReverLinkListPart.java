package algorithms;

import java.util.Iterator;

/*
 * 题目: 反转部分单向链表
 * 		给定一个单向链表的头节点head，以及两个整数from和to，在单向链表上吧第from个结点到第to个结点这一部分进行反转
 * 例如:
 * 		1->2->3->4->5->null,from = 2， to = 4
 * 		调整结果为:1->4->2->3->5->null
 * 		1->2->3->null,from = 1, to = 3
 * 		调整结果为:3->2->1->null 
 * 要求:
 * 		1、如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1).
 * 		2、如果不满足1<=from<=to<=N，则不用调整
 * *********************************************************************************************************
 * 思路:
 * 		先判断需要反转的位置的数值对不对，如果不对，直接返回头节点，如果正确，则先找到第from-1个结点与to+1个结点的位置，然后定义游标结点与桥结点进行链表
 * 的反转，每循环一次游标就向前移一个结点，如果游标结点移动到了to+1个结点的位置就停止循环，表示反转完了
 */
public class ReverLinkListPart {
	public static void main(String[] args) {//测试用例
		List5 list = new List5();
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0;i < num.length ; i++){
			list.add(num[i]);
		}
		Node5 head = reverse(list.head,2,4);
		
		while( head != null){
			System.out.print(head.value);
			head = head.next;
		}
	}

	public static Node5 reverse(Node5 head , int from , int to){
		int len = 0;
		Node5 node1 = head;//新的头节点
		Node5 fpre = null;//from位置结点的前一结点
		Node5 tpos = null;//to位置结点的后一节点
		while(node1 != null){//定位fpre与tpos的位置
			len++;
			fpre = len == from - 1 ? node1 : fpre;
			tpos = len == to +1 ? node1 : tpos;
			node1 = node1.next;
		}
		if(from > to || from < 1 || to > len){//如果输入的数不对  则不反转
			System.out.println("输入的范围不对");
			return head;
		}
		node1 = fpre == null ? head : fpre.next;
		Node5 node2 = node1.next;//游标结点
		node1.next = tpos;
		Node5 next = null;//桥结点
		while(node2 != tpos){//开始反转
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if(fpre != null){//如果反转不是从头节点开始的  就返回原来的结点
			fpre.next = node1;
			return head;
		}
		return node1;//如果反转是从头结点开始的  就返回新的头节点node1
	}
}
class Node5{
	int value;
	Node5 next;
	Node5(int value){
		this.value = value;
	}
}
class List5{
	Node5 head,node;
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node5(value);
			node = node.next;
		}else{
			head = node = new Node5(value);
		}
	}
}