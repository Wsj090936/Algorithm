package leetCode;

public class Sort_LinkedList {
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
       quickList(head,null); 
       return head;
    }
    public static void quickList(ListNode left,ListNode right){
    	if(left == right || left.next == right){
    		return;
    	}
    	ListNode mid = partation(left,right);
    	quickList(left,mid);
    	quickList(mid.next,right);
    }
    private static ListNode partation(ListNode left,ListNode right){
    	if(left == right || left.next == right){
    		return left;
    	}
    	int key = left.val;
    	ListNode head = left;
    	ListNode cur = left;//小于区域
    	while(left != right){
    		if(left.val < key){//左边界的前一个和当前交换
    			cur = cur.next;
    			swap(cur,left);
    		}
    		left = left.next;
    	}
    	swap(cur,head);//最后将头节点key和中间的数交换
    	return cur;//最后返回中间链表
    }
    private static void swap(ListNode a,ListNode b){
    	int temp = a.val;
    	a.val = b.val;
    	b.val = temp;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(3);
		head.next.next = new ListNode(6);
		ListNode head1 = sortList(head);
		System.out.println(head1.val +""+ head1.next.val +""+ head1.next.next.val);
	}
}
