package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/*
 *  For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree.
 *   Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph,
 *    write a function to find all the MHTs and return a list of their root labels.

	Format
	The graph contains n nodes which are labeled from 0 to n - 1. 
	You will be given the number n and a list of undirected edges (each edge is a pair of labels).
	
	You can assume that no duplicate edges will appear in edges. 
	Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
	
	Example 1:
	
	Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
	
	        0
	        |
	        1
	       / \
	      2   3
	return [1]
	
	Example 2:
	
	Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
	
	     0  1  2
	      \ | /
	        3
	        |
	        4
	        |
	        5
	return [3, 4]
	找出一个图中可以使树达到最小高度的根结点
 */
public class Minimum_Height_Trees_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        if(n <= 1){
            return Collections.singletonList(0);
        }
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ;i++){
            map.put(i,new HashSet<>());
        }
        for(int[] each : edges){//初始化HashMap
            map.get(each[0]).add(each[1]);
            map.get(each[1]).add(each[0]);
        }
        for(int i = 0; i < n ; i++){//将被删除的叶子节点放入list
            if(map.get(i).size() == 1){
                list.add(i);
            }
        }
        while(n > 2){//删除叶子节点
            n = n - list.size();
            List<Integer> list1 = new ArrayList<>();
            for(int leaf : list){
                for(int leaf1 : map.get(leaf)){
                    map.get(leaf).remove(leaf1);//删除结点
                    map.get(leaf1).remove(leaf);//删除结点
                    if(map.get(leaf1).size() == 1){//当为叶子节点时，就入列表
                        list1.add(leaf1);
                    }
                }
            }
            list = list1;
        }
        return list;
    }
}
