package algorithms2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将二叉排序树转化为双向链表
 * @author wushijia
 *
 */
public class Convert {
	public Node2 fun1(Node2 head){
		if(head == null){
			return null;
		}
		Queue<Node2> queue = new LinkedList<>();
		initQueue(head,queue);
		head = queue.poll();
		Node2 cur = null;
		Node2 ptr = head;
		ptr.left = null;
		while(!queue.isEmpty()){//将链表拼接起来
			cur = queue.poll();
			ptr.right = cur;
			cur.left = ptr;
			ptr = cur;
		}
		ptr.right = null;
		return head;
	}
	
	private void initQueue(Node2 head,Queue<Node2> queue ){//将二叉排序树放入队列中
		if(head == null){
			return;
		}
		initQueue(head.left,queue);
		queue.offer(head);
		initQueue(head.right,queue);
	}
}
