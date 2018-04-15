package dynamicProgramming;
/**
 * 给出一个二叉树，求出二叉树中最大的路径和，即节点的值的和
 * @author wushijia
 *
 */
public class MaxSum_TreePath {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int value){
			this.value = value;
		}
	}
	public static int getMaxPath(Node root){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return root.value;
		}
		int left = 0;
		int right = 0;
		if(root.left != null){//先找左子树
			left = getMaxPath(root.left)+root.value;
		}
		if(root.right != null){//再找右子树
			right = getMaxPath(root.right)+root.value;
		}
		return Math.max(left, right);
	}
/**
 * 			1
 * 		2		3
 * 	  4	  5   6   7
 * 8    9
 * 
 * 
 * @param args
 */
	public static void main(String[] args) {
		Node root = new Node(1);
		Node root1 = new Node(2);
		Node root2 = new Node(3);
		Node root3 = new Node(4);
		Node root4 = new Node(5);
		Node root5 = new Node(6);
		Node root6 = new Node(7);
		Node root7 = new Node(8);
		Node root8 = new Node(9);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;
		root2.left = root5;
		root2.right = root6;
		root3.left = root7;
		root3.right = root8;
		System.out.println(getMaxPath(root));
	}
}
