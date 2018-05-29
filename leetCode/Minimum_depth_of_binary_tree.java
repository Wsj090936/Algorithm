package leetCode;
/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 * @author wushijia
 *
 */
public class Minimum_depth_of_binary_tree {
	public int run(TreeNode root){
		if(root == null){
			return 0;
		}
		int l = run(root.left);
		int r = run(root.right);
		if(l == 0){//遇到null直接返回
			return r + 1;
		}
		if(r == 0){
			return l + 1;
		}
		return l > r ? r + 1 : l + 1;
	}
}
