package algorithms;
/*
 * Reverse a singly linked list
 * 
 * 思路  题目要求将一个单链表翻转，可以将链表的翻转过程看作一个新链表的创建过程，首先，题目给了我们链表的头节点，我们可以利用这个头节点，
 * 现建立一个游标结点next与一个值为null的空结点ptr，然后进行翻转操作，我们可以将ptr当作新链表的表头，所以在每次操作的时候，总是让next游标结点
 * 指向旧链表表头的下一个结点，然后将旧链表的表头指向ptr，完成之后，再将ptr指向旧链表的表头，最后再将指向旧连表表头的结点指向next结点。如此循环，
 * 链表的翻转就完成了。
 * 
 * 
 * 
 */
public class ReverseLinkedList_206 {
	public static void main(String[] args) {//测试
		List6 list = new List6();
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0;i < num.length ; i++){
			list.add(num[i]);
		}
		Node6 head = reverselist(list.head);
		
		while( head != null){
			System.out.print(head.value);
			head = head.next;
		}
		/**
		 * 原链表 123456789
		 * 现链表 987654321
		 */
	}
	public static Node6 reverselist(Node6 head){
		Node6 ptr = null;//新链表的头节点
		Node6 next = null;//游标结点
		while(head != null){
			next = head.next;
			head.next = ptr;
			ptr = head;
			head = next;
		}
		return ptr;
		
	}
}
class Node6{//结点类
	int value;
	Node6 next;
	Node6(int value){
		this.value = value;
	}
}
class List6{//链表类
	Node6 head,node;
	List6(){
		head = node = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node6(value);
			node = node.next;
		}else
			head = node = new Node6(value);
	} 
}