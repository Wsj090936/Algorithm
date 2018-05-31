package leetCode;
/**
 * 用插入排序排序一个链表
 * @author wushijia
 *
 */
public class Insert_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode ptr = new ListNode(0);//记录指针，每次的位置的比当前大的前一个节点
        ListNode prehead = ptr;
        ListNode cur = head;
        ListNode next = cur;
        while(cur != null){
        	next = cur.next;
        	ptr = prehead;//每次都从原点出发.因为左半部分已经调整完成
        	while(ptr.next != null && ptr.next.val < cur.val){//如果ptr所在位置的next值小于cur，将ptr调整到合适的位置
        		ptr = ptr.next;
        	}
        	cur.next = ptr.next;
        	ptr.next = cur;
        	cur = next;
        }
        return prehead.next;//返新得头节点
    }
}
