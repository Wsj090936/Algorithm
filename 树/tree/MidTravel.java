package tree;

import java.util.Stack;

import tree.preTravel.Node;

/**
 * 二叉树的中序遍历，递归
 * @author wushijia
 *
 */
public class MidTravel {
	public static class Node{
		public int value;
		public Node right;
		public Node left;
		public Node(int data){
			this.value = data;
		}
	}
	public static void MinTravel(Node root){
		if(root == null){
			return;
		}
		MinTravelPrint(root.left);
		System.out.println(root.value);
		MinTravelPrint(root.right);
	}
	public static void MinTravelPrint(Node head){
		System.out.println("中序遍历");
		if(head != null){
			Stack<Node> stack = new Stack<>();
			while(!stack.isEmpty() || head != null){
				if(head != null){
					stack.push(head);
					head = head.left;
				}else{
					head = stack.pop();
					System.out.println(head.value);
					head = head.right;
				}
			}
		}
	}
}
