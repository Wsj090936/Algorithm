package tree;

import java.util.Stack;

public class Travels {
	public class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int value){
			this.value = value;
		}
	}
	public static void preTravel(Node head){
		System.out.println("前序遍历：");
		if(head != null){
			Stack<Node> stack = new Stack<>();
			stack.push(head);
			while(!stack.isEmpty()){
				head = stack.pop();
				System.out.println(head.value+" ");
				if(head.right != null){
					stack.push(head.right);
				}
				if(head.left != null){
					stack.push(head.left);
				}
			}
			
		}
	}
	
	public static void midTravel(Node head){
		System.out.println("中序遍历");
		if(head != null){
			Stack<Node> stack = new Stack<>();
			while(!stack.isEmpty() || head != null){
				if(head != null){
					stack.push(head);
					head = head.left;
				}else{
					head = stack.pop();
					System.out.println(head.value+" ");
					head = head.right;
				}
			}
		}
	}
	
	public static void posTravel(Node head){
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
				System.out.println(stack2.pop().value+" ");
			}
		}
	}
}
