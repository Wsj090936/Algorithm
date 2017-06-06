package algorithms;
/*
 * 在单链表或者双链表中删除并返回倒数第K个节点
 * 	分别实现两个函数，一个可以删除单链表中倒数第K个节点，另一个可以删除双链表中倒数第K个节点
 * 	|----------要求：如果链表长度为N，时间复杂度达到O(N),额外空间复杂度达到O(1)
 * ***********************************************************************************************
 * 解题思路:
 * 		由于要删除倒数第k个结点，所以先进行判断，从头结点开始遍历，每经过一个结点k值就减一，当到尾部时，查看k值，若k值为0，
 * 则要删除的结点为头节点，若k值大于零，则表明要删除的结点根本不存在，若是k小于0，则从头结点开始依次往后遍历，每经过一个结点K就加一，
 * 当k为0的时候，当前的遍历位置就刚好在需要删除的结点的前一个结点，然后将当前结点的next指向next.next即可
 */
public class DeleteLastthNode {//删除单链表的倒数第K个结点
	public static void main(String[] args) {
		List list = new List();
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0;i < num.length;i++){
			list.add(num[i]);
		}
		Node node = DeleteNode(list.head,2);
		System.out.println(node.value);
	}
	public static Node DeleteNode(Node head,int k){
		if(head == null || k<1){//如果链表为空或者k的值小于1，则返回空值
			return null;
		}
		Node cur = head;//定义游标结点
		Node e = null;//用来存删除的结点
		while(cur != null){
			--k;
			cur = cur.next;
		}
		if(k == 0){//如果k为0，返回头节点
			 e = head;
			 head = head.next;
		}else if(k > 0){//k>0时不存在倒数第k个文件
			return null;
		}else if(k < 0){
			cur = head;
			while(++k != 0){
				cur = cur.next;
			}
			e = cur.next;
			cur.next = cur.next.next;//删除倒数第K个结点
		}
		return e;
	}
	public doubleNode DeleteDoubleNode(int k){//删除双链表的倒数第K个结点
		return null;
	}
}
class Node1{//结点类
	public int value;
	public Node1 next;
	Node1(int value){
		this.value = value;
	}
}
class doubleNode{
	
}
class List1{//链表类
	public Node1 head;
	public Node1 node;
	List1(){
		head = node = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node1(value);
			node = node.next;
		}else{
			node = new Node1(value);
			head = node;
		}
	}
}

