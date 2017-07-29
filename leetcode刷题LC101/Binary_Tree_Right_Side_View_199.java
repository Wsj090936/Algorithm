package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

	For example:
	Given the following binary tree,
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
	You should return [1, 3, 4].
 * @author wushijia
 *题目大意：给出一个二叉树，现在想象你自己站在二叉树的右边，编写一个函数返回你能够看到的二叉树的节点集合
 *思路：先利用宽度优先搜索，得出每一层的集合，然后再取出每一层的集合将每一层的集合中的最后一个元素添加
 *到一个新的集合中输出即可。
 */
public class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(tmp);
            size = queue.size();
        }
        List<Integer> res = new ArrayList<>();
        for(List<Integer> each : list){
            res.add(each.get(each.size() - 1));
        }
        return res;
    }
}
