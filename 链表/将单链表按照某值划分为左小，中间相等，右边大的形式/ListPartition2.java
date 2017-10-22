package algorithms;
/**
 * 进阶方法
 * @author wushijia
 *
 */
public class ListPartition2 {
	public Node fun2(Node head,int pivot){
		Node sH = null;//小链表的头
		Node sT = null;//小链表的尾
		Node eH = null;//相同链表的头
		Node eT = null;//相同链表的尾
		Node bH = null;//大链表的头
		Node bT = null;//大链表的尾
		Node next = null;//存储下一个节点
		while(head != null){
			next = head.next;
			head.next = null;
			if(head.value < pivot){//小
				if(sH == null){
					sH = head;
					sT = head;
				}else{//向尾部插入节点
					sT.next = head;
					sT = head;
				}
			}else if(head.value == pivot){
				if(eH == null){
					eH = head;
					eT = head;
				}else{
					eT.next = head;
					eT = head;
				}
			}else{
				if(bH == null){
					bH = head;
					bT = head;
				}else{
					bT.next = head;
					bT = head;
				}
			}
			head = next;//每次头结点都会变，因为之前的节点被分配到那三个链表中了

		}
		if(sT != null){
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		if(eT != null){
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;//判断返回合成链表的头结点
	}
}
