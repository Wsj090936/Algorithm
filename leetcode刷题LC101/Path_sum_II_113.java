package algorithms;

import java.util.ArrayList;
import java.util.List;
/**
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 * @author wushijia
 *
 */
public class Path_sum_II_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List list = new ArrayList<>();
        DFS(root,sum,res,list);
        return res;
    }
    public void DFS(TreeNode root ,int sum,List<List<Integer>> res,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        } else{
            DFS(root.left,sum - root.val,res,list);
            DFS(root.right,sum - root.val,res,list);
        }
        list.remove(list.size() - 1);
    }
}
