package tree;
/**
 * 打印一颗树的边界节点
 * @author wushijia
 *
 */
public class PrintEdge {
	public class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int data){
			this.value = data;
		}
	}
	public static void printNode(Node head){
		if(head == null){
			return;
		}
		//用一个二维数组将二叉树中的边界节点全部保存在该数组中
		//首先得先知道该树的高度
		int height = getHeight(head,0);
		Node[][] edgeMap = new Node[height][2];//（0，0）记录第一层的左边界，(0,1)记录有边界，以此类推
		setEdgeMap(edgeMap,head,0);
		for(int i = 0;i < edgeMap.length;i++){
			System.out.println(edgeMap[i][0].value+" ");
		}
		//然后打印既不是左边界，又不是有边界的叶子结点
		printNotEdgeNode(head,0,edgeMap);
		//打印右边界节点但它不是左边界
		for(int i = 0;i < edgeMap.length;i++){
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.println(edgeMap[i][1]+" ");
			}
		}
	}
	private static void printNotEdgeNode(Node head, int i, Node[][] edgeMap) {
		if(head == null){
			return;
		}
		if(head.left == null && head.right == null && head != edgeMap[i][0] && head != edgeMap[i][1]){
			System.out.println(head.value);
		}
		printNotEdgeNode(head.left,i+1,edgeMap);
		printNotEdgeNode(head.right,i+1,edgeMap);
		
	}
	private static void setEdgeMap(Node[][] edgeMap,Node h,int l){//将边界全部放入该二维数组
		if(h == null){
			return;
		}
		edgeMap[l][0] = edgeMap[l][0] == null ? h:edgeMap[l][0];
		edgeMap[l][1] = h;
		setEdgeMap(edgeMap,h.left,l+1);
		setEdgeMap(edgeMap,h.right,l+1);
	}
	private static int getHeight(Node head,int l){//得到树的高度
		if(head == null){
			return l;
		}
		return Math.max(getHeight(head.left,l++), getHeight(head.right,l++));
	}
}
