package algorithms;
/*
 * 题目:给出链表表头head分别实现单链表和双链表的反转并返回其头节点
 * 要求:如果链表长度为N，时间复杂度要求为O(N),额外空间复杂度为O(1)
 * *******************************************************************
 * 思路:
 * 			由于给出了头结点head,要求我们去翻转一个链表，且时间复杂度为O(N)，所以可以这样做:我们可以将翻转看作是创建一个新链表的过程定义两个游标结点，
 * 一个为ptr，一个为next，ptr为新结点的头结点，next刚开始指向旧链表的头节点，每次翻转结点我只需要将旧链表的头结点指向新链表的头节点，然后新链表的头节
 * 点向后移变为刚刚插入的新结点，旧链表的头节点变为刚刚删除的结点的下一个结点就好了，具体代码看方法
 */
public class ReverseLinkList {
public static void main(String[] args) {//测试用例
	List4 list = new List4();
	int[] num = new int[]{1,2,3,4,5,6,7,8,9};
	for(int each:num){
		list.add(each);
	}
	System.out.println("原链表为:");
	Node4 cur = list.head;
	for(int i = 0; i<num.length;i++){
		System.out.print(cur.value);
		cur = cur.next;
	}
	System.out.println();
	Node4 cur1 = reverseList(list.head);
	System.out.println("翻转后链表为:");
	for(int i = 0; i<num.length;i++){
		System.out.print(cur1.value);
		cur1 = cur1.next;
	}
	/*
	 * 运行结果:原链表为:
				123456789
				翻转后链表为:
				987654321
	 * 
	 */
}
	public static Node4 reverseList(Node4 head){//翻转链表
		Node4 ptr = null;//每次循环一次都位于表头，想当于新链表的头节点
		Node4 next = null;//游标结点，每循环一次都位于原结点的表头
		while(head != null){
			next = head.next;
			head.next = ptr;
			ptr = head;
			head = next;
		}
		return ptr;
	}
}
class Node4{
	int value;
	Node4 next;
	Node4(int value){
		this.value = value;
	}
}
class List4{//单链表
	Node4 head,node;
	List4(){
		head = node = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node4(value);
			node = node.next;
		}else{
			head = node = new Node4(value);
		}
	}
}