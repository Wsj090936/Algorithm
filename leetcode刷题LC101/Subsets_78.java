package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a set of distinct integers, nums, return all possible subsets.

	Note: The solution set must not contain duplicate subsets.
	
	For example,
	If nums = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 * @author wushijia
 *
 */
public class Subsets_78 {
    private void solve(int[] nums,List<List<Integer>> res,List<Integer> list,int index){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        solve(nums,res,list,index + 1);
        list.add(nums[index]);
        solve(nums,res,list,index + 1);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        
        solve(nums,res,list,0);
            return res;
    }
}
