package linkedList;
/**
 * 将一个链表调整为左边比某一个数小。中间和它相等，右边比他大
 * @author wushijia
 *
 */
public class LinkedListPartation {
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
	}
	public Node partation(Node head,int n){
		Node smallH = null;//小于头
		Node smallT = null;//小于尾部
		Node equalH = null;//等
		Node equalT = null;
		Node moreH = null;//大
		Node moreT = null;
		Node ptr = head;
		while(ptr != null){//遍历链表 将大于、等于、小于部分都放在以上的节点中
			ptr = head.next;//保存下一个节点
			head.next = null;
			if(head.value < n){
				if(smallH == null){
					smallH = head;
					smallT = head;
				}else{
					smallT.next = head;
					smallT = head;
				}
			}else if(head.value == n){
				if(equalH == null){
					equalH = head;
					equalT = head;
				}else{
					equalT.next = head;
					equalT = head;
				}
			}else{
				if(moreH == null){
					moreH = head;
					moreT = head;
				}else{
					moreT.next = head;
					moreT = head;
				}
			}
			head = ptr;
		}
		if(smallT != null){
			smallT.next = equalH;
			equalT = equalT == null?smallT:equalT;
		}
		if(equalT != null){
			equalT.next = moreH;
		}
		return smallH != null ? smallH : equalH != null ? equalH : moreH;
	}
}
