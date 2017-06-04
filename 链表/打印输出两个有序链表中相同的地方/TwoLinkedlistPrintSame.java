package algorithms;
/*
 *给出两个有序链表的表头指针head1与head2，打印两个链表的公共部分； 
 *
 *由于是有序链表，所以可以直接判断头节点的值，若head1大于head2的值，则head2指向下一位，否则head1指向下一位
 */
public class TwoLinkedlistPrintSame {
public static void printSame(Node head1,Node head2){
	while(head1 != null && head2 != null){
		if(head1.value > head2.value){
			head2 = head2.next;
		}else if(head1.value < head2.value){
			head1 = head1.next;
		}else{
			System.out.println(head1.value);
			head1 = head1.next;
			head2 = head2.next;
		}
	}
}
public static void main(String[] args){//测试用例
	List list1 = new List();
	List list2 = new List();

	int[] num = new int[]{1,2,3,4,5,6,7,8,9};
	int[] num2 = new int[]{3,1,2,4,5,6,7,98,9,4,5,7};
	for(int i = 0;i < num.length;i++){
		list1.add(num[i]);
	}
	for(int i = 0;i < num2.length;i++){//控指针异常
		list2.add(num2[i]);
	}
	printSame(list1.head,list2.head);
}
}
class Node{//定义节点类
	public int value;
	public Node next;
	Node(int value ){
		this.value = value;
	}
}
class List{//定义链表类
	public Node node,head;
	List(){
		node = head = null;
	}
	public boolean isEmpty(){//头节点为空即链表为空
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node(value);//一定要这样写否则会有逻辑错误！血的教训，应该先初始化下一个节点然后再移动指向
			node = node.next;
		}else{
			head = node = new Node(value);
		}
		
	}
}
