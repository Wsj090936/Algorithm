package algorithms;
/*
 * Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	
	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

	思路:题目要求我们翻转相邻的两个结点，所以我们可以定义三个游标结点，两个指针结点用来指向将要被翻转部分的第一个结点和第二个结点，
	另一个指针指向被翻转后的尾结点，用于与下一次翻转后的链表做连接
 */
public class SwapNodesInPairs_24 {
	public static void main(String[] args) {
		List8 list1 = new List8();
		int[] num = new int[]{1,2,3};
		for(int i = 0;i < num.length;i++){
			list1.add(num[i]);
		}
		Node8 A = swapPairs(list1.head);
		while(A != null){
			System.out.print(A.value+",");
			A = A.next;
		}
	}
	public static Node8 swapPairs(Node8 head) {
        if(head == null){
            return null;
        }
        Node8 ptr = head;//被翻转部分的第一个结点
        Node8 cur = ptr.next;//被翻转部分的第二个结点
        Node8 front = null;//被翻转后链表的尾结点
        if(cur == null){
            return head;
        }else{
            head = cur;
            while(true){//开始翻转
                    front = ptr;
                    ptr.next = cur.next;
                    cur.next = ptr;
                    if(ptr.next == null){
                    	return head;
                    }
                    ptr = ptr.next;
                    if(ptr.next == null){
                    	return head;
                    }
                    cur = ptr.next;                    	
                    front.next = cur;      
            }  
        }
    }
}
class Node8{//定义节点类
	public int value;
	public Node8 next;
	Node8(int value ){
		this.value = value;
	}
}
class List8{//定义链表类
	public Node8 node,head;
	List8(){
		node = head = null;
	}
	public boolean isEmpty(){//头节点为空即链表为空
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node8(value);//一定要这样写否则会有逻辑错误！血的教训，应该先初始化下一个节点然后再移动指向
			node = node.next;
		}else{
			head = node = new Node8(value);
		}
		
	}
}