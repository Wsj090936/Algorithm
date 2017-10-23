package algorithms2;

import java.util.HashMap;
import java.util.Map;
/**
 * 复制还有随机指针节点的链表
 * 思路：
 * 		先将所有节点遍历一遍并复制放入哈希表map中，以原来节点作为key，复制的节点作为value
 * 然后再遍历一次链表将每一个节点的next和rand节点拼接起来，返回get(head)即可
 * @author wushijia
 *
 */
public class CopyListWithRandom {
	public RandNode fun1(RandNode head){
		if(head == null){
			return null;
		}
		Map<RandNode,RandNode> map = new HashMap<>();
		RandNode cur = head;
		while(cur != null){//先遍历一次链表，复制所有节点到map中
			map.put(cur, new RandNode(cur.value));
			cur = cur.next;
		}
		cur = head;
		while(cur != null){
			map.get(cur).next = map.get(cur.next);//将原来的链表相接
			map.get(cur).rand = map.get(cur.rand);//将随机链表相接
			cur = cur.next;
		}
		return map.get(head);//将新链表的头结点返回
	}
}
