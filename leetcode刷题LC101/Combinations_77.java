package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 * @author wushijia
 *用递归的解法
 */
public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res,list,n,k,1);
        return res;
    }
    private void dfs(List<List<Integer>> res,List<Integer> list,int n,int k,int m){
        if( k == 0 ){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = m;i <= n;i++){
            list.add(i);
            dfs(res,list,n,k - 1,i + 1);
            list.remove(list.size() - 1);
        }
    }
}
