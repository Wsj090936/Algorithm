package algorithms2;

import java.util.Stack;
/**
 *两个链表相加生成单链表，每一个节点的数值小于10
 * @author wushijia
 *
 */
public class AddList {
	public Node fun1(Node head1,Node head2){
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while(head1 != null){
			s1.push(head1.value);
			head1 = head1.next; 
		}
		while(head2 != null){
			s2.push(head2.value);
			head2 = head2.next;
		}
		int n1 = 0;//链表一的加数
		int n2 = 0;//链表二的加数
		int n = 0;//所得和
		int a = 0;//进位
		Node cur = null;//活动指针
		Node res = null;//活动指针
		while(!s1.isEmpty() && !s2.isEmpty()){
			n1 = s1.isEmpty() ? 0 : s1.pop();//弹出加数
			n2 = s2.isEmpty() ? 0 : s2.pop();//弹出加数
			n = n1 + n2 + a;
			cur = res;
			res = new Node(n % 10);
			res.next = cur;//尾插法插入节点
			a = n/10;//产生进位
		}
		if(a == 1){//最高位有进位时，再新增一个节点
			cur = res;
			res = new Node(1);
			res.next = cur;
		}
		return res;
	}
}
