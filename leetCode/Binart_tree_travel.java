package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class Binart_tree_travel {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
        	return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        ArrayList<Integer> resList = new ArrayList<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
        	root = stack1.pop();
        	resList.add(root.val);
        	if(root.right != null){
        		stack1.push(root.right);
        	}
        	if(root.left != null){
        		stack1.push(root.left);
        	}
        }
        return resList;
    }
}
