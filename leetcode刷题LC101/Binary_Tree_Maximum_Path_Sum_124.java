package algorithms;
/**
 *  Given a binary tree, find the maximum path sum.

	For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
	
	For example:
	Given the below binary tree,
	
	       1
	      / \
	     2   3
	Return 6.
 * @author wushijia
 *
 */
public class Binary_Tree_Maximum_Path_Sum_124 {
    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxPath(root);
        return res;
    }
    private int maxPath(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,maxPath(node.left));//取得左边值
        int right = Math.max(0,maxPath(node.right));//取得右边值
        res = Math.max(res,left + right + node.val);//更新res的值
        return Math.max(left , right) + node.val;//每次递归，取左右子树较大的那个返回
    }
}
