package tree;

public class IsBalance {
	public class Node{
		public int value;
		public Node left;
		public Node right;
	}
	public boolean isBalance(Node head){
		boolean[] res =  new boolean[1];
		res[0] = true;
		getHeight(head,1,res);
		return res[0];
		
	}
	private int getHeight(Node head, int leval, boolean[] res) {
		if(head == null){
			return leval;
		}
		int lH = getHeight(head.left,leval+1,res);
		if(!res[0]){//不满足，退出
			return leval;
		}
		int rH = getHeight(head.right,leval+1,res);
		if(!res[0]){//不满足，退出
			return leval;
		}
		if(Math.abs(lH-rH) > 1){
			res[0] = false;
		}
		//如果不大于1返回较大的那个
		return Math.max(lH, rH);
	}
}
