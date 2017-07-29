package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 * @author wushijia
 *这是一道典型的宽度优先搜索，
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean clear = true;
        int size = 1;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                if(clear){
                    list.add(node.val);
                }else{
                    list.add(0,node.val);//
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(list);
            size = queue.size();
            clear = clear ? false : true;//这里是整个算法的精髓，当遍历到偶数层的时候先添加右节点，当是奇数层的时候先添加左节点
        }
        return res;
    }
}
