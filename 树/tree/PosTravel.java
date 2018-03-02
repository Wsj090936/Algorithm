package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.preTravel.Node;
/**
 * 二叉树的后序遍历
 * @author wushijia
 *
 */
public class PosTravel {
	public static class Node{
		public int value;
		public Node right;
		public Node left;
		public Node(int data){
			this.value = data;
		}
	}
	public static void posTravel(Node root){
		if(root == null){
			return;
		}
		posTravelPrint(root.left);
		posTravelPrint(root.right);
		System.out.println(root.value);
	}
	private static void posTravelPrint(Node head){
		System.out.println("后序遍历");
		if(head != null){
			Stack<Node> stack1 = new Stack<>();
			Stack<Node> stack2 = new Stack<>();
			stack1.push(head);
			while(!stack1.isEmpty()){
				head = stack1.pop();
				stack2.push(head);
				if(head.left != null){
					stack1.push(head.left);
				}
				if(head.right != null){
					stack1.push(head.right);
				}
			}
			while(!stack2.isEmpty()){
				System.out.println(stack2.pop().value);
			}
		}
		
	}
}
