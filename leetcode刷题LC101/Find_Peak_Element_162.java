package algorithms;
/**
 *  A peak element is an element that is greater than its neighbors.

	Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
	
	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	
	You may imagine that num[-1] = num[n] = -∞.
	
	For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * @author wushijia
 *给出一个数组，数组中元素的大小从中间开始到两边逐渐递减，现在用对数的复杂度找出中间的最大元素
 *思路：既然是对数的复杂度，所以应该用二分法
 */
public class Find_Peak_Element_162 {
    public int findPeakElement(int[] nums) {
    	int left = 0;//最左边的指针
    	int right = nums.length - 1;
    	while(left < right){
    		int mid = (right + left)/2;
    		if(nums[mid] < nums[mid + 1]){
    			left = mid + 1;
    		}else
    			right = mid;
    	}
    	return left;
   }
}
