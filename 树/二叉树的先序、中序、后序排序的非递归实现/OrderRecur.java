package algorithms2;

import java.util.Stack;

public class OrderRecur {
	public void preOrderRecur(Node2 root){//œ»–Ú±È¿˙
		if(root != null){
			Stack<Node2> stack = new Stack<>();
			stack.add(root);
			while(!stack.isEmpty()){
				Node2 ptr = stack.pop();
				System.out.println(ptr.value);
				if(ptr.right != null){
					stack.push(ptr.right);
				}
				if(ptr.left != null){
					stack.push(ptr.left);
				}
			}
		}
	}
}
