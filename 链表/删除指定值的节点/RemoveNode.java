package algorithms2;

import java.util.Stack;
/**
 * 删除指定值的节点
 * @author wushijia
 *
 */
public class RemoveNode {
	public Node fun1(Node head,int e){
		if(head == null){
			return null;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		while(cur != null){//将值不为e的节点入栈
			if(cur.value != e){
				stack.push(cur);
			}
			cur = cur.next;
		}
		while(!stack.isEmpty()){//将链表连接起来
			stack.peek().next = cur;
			cur = stack.pop();
		}
		return head;
	}
}
