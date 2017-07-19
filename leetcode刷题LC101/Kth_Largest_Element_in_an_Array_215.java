package algorithms;
/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

	For example,
	Given [3,2,1,5,6,4] and k = 2, return 5.
 * @author wushijia
 *找出一组数中第k大的数
 */
public class Kth_Largest_Element_in_an_Array_215 {
    public int findKthLargest(int[] nums, int k) {//冒泡排序
        int size = nums.length;
        int temp = 0;
        for(int i = 0;i < size;i++){
            for(int j = 0;j < size-1-i;j++){
                if(nums[j] > nums[j + 1]){
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums[size-k];
    }
}
