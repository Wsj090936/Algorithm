package algorithms2;
/**
 * 单链表的选择排序
 * 要求额外空间复杂度为O(1),即不能用容器等工具
 * @author wushijia
 *
 */
public class SelectionSort {
	public Node fun1(Node head){
		Node tail = null;//排序部分的尾部
		Node cur = head;//未排序链表的头结点
		Node smallpre = null;//被删除链表的前一个节点
		Node smallNode = null;//最小的节点
		while(cur != null){
			smallNode = cur;
			smallpre = getSmallpre(head);
			if(smallpre != null){//删除最小节点
				smallNode = smallpre.next;
				smallpre.next = smallNode.next;
			}
			cur = cur == smallNode ? cur.next : cur;
			if(tail == null){//确定头结点
				head = smallNode;
			}else{
				tail.next = smallNode;
			}
			tail = smallNode;
		}
		return head;
	}
	private Node getSmallpre(Node head){//得到最小节点的前一个节点
		Node smallpre = null;
		Node small = head;
		Node pre = head;
		Node cur = head.next;
		while(cur != null){
			if(cur.value < small.value){
				smallpre = pre;
				small = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallpre;
	}
}
