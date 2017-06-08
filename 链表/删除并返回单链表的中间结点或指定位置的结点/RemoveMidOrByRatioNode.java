package algorithms;
/*
 * 删除并返回链表的中间结点和a/b处的结点
 * 题目一：给定链表的头节点head，实现删除链表的中间结点的函数
 * 如：
 * 不删除任何结点
 * 1->2 删除结点1
 * 1->2->3 删除结点2
 * 1->2->3->4 删除结点2
 * 1->2->3->4->5 删除结点3
 * 题目而：给定链表的头节点head，整数a和b，实现删除位于a/b处结点的函数
 * 例如：
 * 链表：1->2->3->4->5，假设a/b的值为r
 * 如果r等于0，不删除任何结点
 * 如果r在区间(0,1/5]上，删除结点1
 * 如果r在区间(1/5,2/5]上，删除结点2
 * 如果r在区间(2/5,3/5]上，删除结点3
 * 如果r在区间(3/5,4/5]上，删除结点4
 * 如果r在区间(4/5,1]上，删除结点5
 * 如果r>1 不删除任何结点
 * **************************************************************************
 * 解题思路：
 * 题目一：
 * 		题目一中给了出头节点，去删除中间结点，所以可以定义两个快慢游标结点slow与fast，将头结点head的地址赋给slow，
 * 然后将head.next.next的地址赋给fast(因为是删除中间结点，而不是查找，如果为查找，就将head的地址赋给它),然后进行循环，
 * 每循环一次slow结点向前走一位，fast结点向前走两位，当fast.next.next并且fast.next为空时，循环结束，此时slow的位置就位于中间结点的前一个结点，
 * 接下来就可以进行删除操作了
 * 题目而：
 * 		题目二中要求删除位于a/b位置的结点，可以从题目中区间中看出，当a/b为浮点数的时候，举个例子，当a/b为0.1的时候，就要删除第一个结点了，
 * 意味着0.1这个数转换为int型时向上取整了，所以可以总结出一个公式 double r = ((double)(a*n)/(double)b) ，其中n为链表长度，该公式算出的值r经过向上取整所得
 * 的整数就为被删除的结点，所以只需要算出r并将其向上取整，就能够找到被删除的结点了；
 */
public class RemoveMidOrByRatioNode {
	public static void main(String[] args) {//测试用例
		List3 list = new List3();
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0 ;i<num.length;i++){
			list.add(num[i]);
		}
//		Node3 cur = list.head;
//		while(cur != null){
//			System.out.println(cur.value);
//			cur = cur.next;
//		}
		Node3 e = null;
		e = deletemid(list.head);
		System.out.println(e.value);
		System.out.println(deleteByRatio(list.head,3,9).value);//输出结果为3
		
	}
//------------------算法如下-------------------------
	public static Node3 deletemid(Node3 head){
		Node3 e = null;//用来存被删除的结点
		Node3 slow = head;//慢指针
		Node3 fast = head.next.next;//快指针
		if(head == null || head.next == null){//当链表为空或只有一个结点的时候，直接返回
			return head;
		}
		if(head.next.next == null){//当链表中的结点数为2时，返回头节点
			e = head;
			head = head.next;
		}else{
		while(fast.next != null && fast.next.next != null){//当fast.next.next或者fast.next为空的时候，slow刚好指向中间结点的前一个结点
			slow = slow.next;
			fast = fast.next.next;
		}
		e = slow.next;
		slow.next = slow.next.next;//删除中间结点
		}
		return e;
	}
	public static Node3 deleteByRatio(Node3 head,int a,int b){//删除位于a/b的结点
		Node3 e = null;//用来存被删除的结点
		if(a>b || a<1){
			System.out.println("输入的值不对");
			return null;
		}
		int n = 0;//用来记录链表长度
		Node3 cur = head;//游标结点
		while(cur != null){//获取链表长度
			cur = cur.next;
			n++;
		}
		n = (int)Math.ceil((double)(a*n)/(double)b);//向上取整，表示删除第n个结点
		if(n == 1){//删除第一个结点直接返回头节点
			e = head;
			head = head.next;
		}else if(n > 1){
			cur = head;
			while(--n != 1){//当游标位于a/b处的结点的前一个结点时，循环终止
				cur = cur.next;
			}
			e = cur.next;
			cur.next = cur.next.next;
		}
		return e;
		
	}
}
class Node3{//结点类
	public int value;
	public Node3 next;
	Node3(int value){
		this.value = value;
	}
}
class List3{//单链表类
	Node3 head,node;
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node3(value);
			node = node.next;
		}else{
			node = new Node3(value);
			head = node;
		}
	}
}
