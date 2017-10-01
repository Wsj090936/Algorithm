package algorithms;
/**
 * 环形链表的约瑟夫问题，普通方法和进阶方法
 * @author wushijia
 *
 */
public class JosephusKill {
	public ListNode fun1(ListNode head , int m){//普通方法
		if(head == null || m < 1 || head.next == head){
			return head;
		}
		ListNode lastnode = head;
		while(lastnode.next != head){//找到最后一个节点
			lastnode = lastnode.next;
		}
		int count = 0;
		while(head != lastnode){
			if(++count == m){//当count == m时，删除节点
				lastnode.next = head.next;
				count = 0;
			}else{
				lastnode = lastnode.next;
			}
			head = lastnode.next;//遍历+1
		}
		return head;
	}
	public ListNode fun2(ListNode head,int m){//进阶方法
		if(head == null || head.next == head || m < 1){
			return head;
		}
		ListNode cur = head.next;
		int i = 1;//链表大小
		while(cur != head){
			++i;
			cur = cur.next;
		}
		i = getLive(i,m);
		while(--i != 0){
			head = head.next;
		}
		head.next = head;
		return head;
	}
	private int getLive(int i, int m) {
		if(i == 1){
			return 1;
		}
		return (getLive(i - 1,m) + m -1) % i + 1;
	}
}
