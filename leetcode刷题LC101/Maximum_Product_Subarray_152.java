package algorithms;
/**
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

	For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6.
 * @author wushijia
 *
 */
public class Maximum_Product_Subarray_152 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int max = nums[0],min = nums[0],res = nums[0];
        for(int i = 1;i < nums.length;i++){
            int temp = max;
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);//递推式
            min = Math.min(Math.min(temp*nums[i],min*nums[i]),nums[i]);
            if(max > res){//最大的改变
            	res = max;
            }
        }
        return res;
    }
}
