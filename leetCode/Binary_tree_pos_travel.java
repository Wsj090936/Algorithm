package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * 二叉树得后序遍历
 * @author wushijia
 *
 */
public class Binary_tree_pos_travel {
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
        	root = stack1.pop();
        	stack2.push(root);//栈中从上到下是左  右  根
        	if(root.left != null){
        		stack1.push(root.left);
        	}
        	if(root.right != null){
        		stack1.push(root.right);
        	}
        }
        ArrayList<Integer> resList = new ArrayList<>();
        while(!stack2.isEmpty()){
        	resList.add(stack2.pop().val);
        }
        return resList;
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		ArrayList<Integer> list = postorderTraversal(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
