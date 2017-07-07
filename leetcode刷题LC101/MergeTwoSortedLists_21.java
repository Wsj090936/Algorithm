package algorithms;
/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 * 
 * 合并两个已排序链表并将其作为新列表返回。新列表应该通过拼接前两个列表的节点来完成
 * 
 * 例如:1->2->4->5->6->null
 *      1->3->5->7->null
 * 合并后结果为: 1->1->2->3->4->5->5->6->7
 * 
 * 思路: 题中给出了两个已排序链表list1与list2的头节点，让我们来拼接两个链表返回一个新的链表，首先，先确定新链表的头节点head，
 * 取两个原链表中头节点较小的那个结点作为新链表的头节点，然后定义两个游标结点ptr1与ptr2来分别从头遍历list1与list2
 * 遍历方式如下：ptr1与ptr2分别从list1与list2的头节点出发，先判断ptr1与ptr2的值，找出二者中较小的那个，假设list1的头节点的值小于
 * list2的头节点的值，然后用一个变量pre来指向ptr1，然后ptr1指向其下一个结点，然后循环，假如下次比较时，ptr1的值大于ptr2的值，则用一个新
 * 的结点next指向ptr2的下一个结点，然后将pre.next指向ptr2，ptr2.next指向ptr1,这样，一次拼接的过程就完成了，然后将pre指向刚刚拼接过去的
 * 结点，并且ptr2指向下一个结点即ptr2 = next;如此循环，最终总会有一个链表先遍历完，则将未遍历完的链表部分直接拼接到pre后即可。
 * 
 */
public class MergeTwoSortedLists_21 {
	public static void main(String[] args) {
		List7 list = new List7();
		List7 list1 = new List7();
		int[] num = new int[]{1,2,3,5,7,8};
		int[] num1 = new int[]{1,3,5,9};
		for(int each:num){
			list.add(each);
		}
		for(int each:num1){
			list1.add(each);
		}
		Node7 cur1 = mergeTwoLists(list.head,list1.head);
		while(cur1 != null){
			System.out.println(cur1.value);
			cur1 = cur1.next;
		}
	}
	public static Node7 mergeTwoLists(Node7 l1,Node7 l2){
        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }
		Node7 head = l1.value < l2.value ? l1 : l2;//新链表的头节点
		Node7 ptr1 = head == l1 ? l1 : l2;//游标结点
		Node7 ptr2 = head == l1 ? l2 : l1;//游标结点
		Node7 pre = null;//该结点指向两个游标结点中较小的那个结点
		Node7 next = null;
		while(ptr1 != null && ptr2 != null){
			if(ptr1.value <= ptr2.value){
				pre = ptr1;
				ptr1 = ptr1.next;
			}else{//开始拼接
				next = ptr2.next;
				pre.next = ptr2;
				ptr2.next = ptr1;
				pre = ptr2;
				ptr2 = next;
			}
			
		}
		pre.next = ptr1 == null ? ptr2 : ptr1;
		return head;
	}
}
class Node7{
	int value;
	Node7 next;
	Node7(int value){
		this.value = value;
	}
}
class List7{//单链表
	Node7 head,node;
	List7(){
		head = node = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node7(value);
			node = node.next;
		}else{
			head = node = new Node7(value);
		}
	}
}