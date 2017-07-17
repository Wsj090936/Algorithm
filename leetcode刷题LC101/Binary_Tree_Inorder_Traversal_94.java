package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 要求实现二叉树的中序遍历
 * @author wushijia
 *
 */
public class Binary_Tree_Inorder_Traversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {//递归方式
    	List<Integer> list = new ArrayList<>();
    	if(root == null){
    		return list;
    	}
    	list.addAll(inorderTraversal(root.left));
    	list.add(root.val);
    	list.addAll(inorderTraversal(root.right));
    	return list;
    }
    public List<Integer> inorderTraversal1(TreeNode root) {//非递归方式
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
