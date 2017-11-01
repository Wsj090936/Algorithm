package algorithms2;
/**
 * 合并两个有序的单链表
 * @author wushijia
 *
 */
public class MergeList {
	public Node fun1(Node head1,Node head2){
		if(head1 == null || head2 == null){
			return head1 != null ? head1 : head2;
		}
		Node head = head1.value < head2.value ? head1 : head2;//取最小的头节点为新链表的头结点
		Node cur1 = head == head1 ? head1 : head2;//链表一的哨兵
		Node cur2 = head == head1 ? head2 : head1;//链表二的哨兵
		Node pre = null;//调整了的节点
		Node next = null;//链表2中的下一个节点
		while(cur1 != null && cur2 != null){//只要有一个链表遍历完成就退出
			if(cur1.value < cur2.value){//第一次不用调整
				pre = cur1;
				cur1 = cur1.next;
			}else{
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}
		pre.next = cur1 == null? cur2 : cur1;//将未遍历完的链表拼接
		return head;
	}
}
