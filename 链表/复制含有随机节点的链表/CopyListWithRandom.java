package algorithms2;

import java.util.HashMap;
import java.util.Map;
/**
 * 复制还有随机指针节点的链表
 * @author wushijia
 *
 */
public class CopyListWithRandom {
	/**
	 * 思路：方法一
	 * 		先将所有节点遍历一遍并复制放入哈希表map中，以原来节点作为key，复制的节点作为value
	 * 然后再遍历一次链表将每一个节点的next和rand节点拼接起来，返回get(head)即可
	 * @param head
	 * @return
	 */
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
	/**
	 * 方法二：进阶方法
	 * 	先将链表中的每一个节点进行复制，并且拼接到原来节点后面，然后再遍历一遍链表，将复制的节点之间的rand节点连接起来
	 * 最后再遍历一次链表，将原来的链表和复制所得的链表拆分开来即可，过程中需要注意判断节点是否为null
	 * @param head
	 * @return
	 */
	public RandNode fun2(RandNode head){
		if(head == null){
			return null;
		}
		RandNode cur = head;//用于遍历节点
		RandNode next = null;//存储下一个节点的变量
		while(cur != null){//将每一个链表的节点复制并加到他们的后面
			next = cur.next;
			cur.next = new RandNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		RandNode copyCur = null;
		while(cur != null){//将复制的链表之间的关系相互连接起来
			next = cur.next.next;//将cur移动到原链表的第二个节点
			copyCur = cur.next;
			copyCur.rand = cur.rand != null ? cur.rand.next : null;//这里之所以为cur.rand.next，是因为要让复制的节点指向原来节点的rand节点的复制节点
			cur = next;
		}
		cur = head;
		RandNode res = head.next;//复制所得链表的表头
		while(cur != null){//将原链表和复制链表相分离
			next = cur.next.next;
			copyCur = cur.next;
			cur.next = next;//原链表连接
			copyCur.next = next != null ? next.next : null;//复制所得链表进行拼接
			cur = next;
		}
		return res;
	}
}
