package algorithms2;

import java.util.HashSet;
import java.util.Set;
/**
 * 删除一个链表中有重复值的节点，要求时间复杂度为O(N)
 * @author wushijia
 *
 */
public class RemoveRep {
	public Node fun1(Node head){
		if(head == null){
			return null;
		}
		Set<Integer> set = new HashSet<>();
		Node cur = head.next;
		Node ptr = head;
		set.add(head.value);
		while(cur != null){
			if(set.contains(cur.value)){
				ptr.next = cur.next;
			}else{
				set.add(cur.value);
				ptr = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}
