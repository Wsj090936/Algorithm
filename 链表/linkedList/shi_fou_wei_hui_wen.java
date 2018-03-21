package linkedList;
/**
 * 判断一个链表是否为回文结构
 * 普通解法：空间复杂度为o(n)  将链表的右半部分压入栈，然后和左半部分开始比较，只要有一个不一样，就返回false，否则返回true
 * @author wushijia
 * 进阶解法：空间复杂度为O(1)  找到链表的中点位置，然后将右半区逆序，左右半区开始比较
 *  1 2 3 4 5 6
 */
public class shi_fou_wei_hui_wen {
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
	}
	public boolean judge(Node head){
		if(head == null){
			return false;
		}
		Node slow = head;
		Node fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node ptr = slow.next;//右边部分第一个节点
		slow.next = null;
		Node next = null;
		while(ptr != null){//将右半部分逆序
			next = ptr.next;
			ptr.next = slow;
			slow = ptr;
			ptr = next;
		}
		next = slow;//slow为右半部分的头节点，也是链表的最后一个节点
		ptr = head;
		boolean res = true;
		while(slow != null&&ptr != null){
			if(slow.value != ptr.value){
				res = false;
				break;
			}
			slow = slow.next;//右到左
			ptr = ptr.next;//左到右
		}
		slow = next.next;//存储下一个节点
		next.next = null;//next是最后一个节点
		while(slow != null){//将链表调整过来
			ptr = slow.next;
			slow.next = next;
			next = slow;
			slow = ptr;
		}
		return res;
	}
}
