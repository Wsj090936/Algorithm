package tree;

import java.util.Stack;
/**
 * 二叉树的前序遍历，非递归
 * @author wushijia
 *
 */
public class preTravel {
	public static class Node{
		public int value;
		public Node right;
		public Node left;
		public Node(int data){
			this.value = data;
		}
	}
	public static void preTravel(Node root){
		if(root == null){
			return;
		}
		System.out.println(root.value);
		preTravelPrint(root.left);
		preTravelPrint(root.right);
	}
	private static void preTravelPrint(Node head){
		System.out.println("前序遍历：");
		if(head != null){
			Stack<Node> stack = new Stack<>();
			stack.add(head);
			while(!stack.isEmpty()){
				head = stack.pop();
				System.out.println(head.value);
				if(head.right != null){
					stack.push(head.right);
				}
				if(head.left != null){
					stack.push(head.left);
				}
			}
		}
		
	}
}
