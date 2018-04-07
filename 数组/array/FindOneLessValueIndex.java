package array;
/**
 * 在数组中找到一个局部最小的位置 
 * 【题目】 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
 * arr的长度为 N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，
 * 既有 arr[i]<arr[i-1]，又有arr[i]<arr[i+1]，那么arr[i]是局部最小。 
 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等。写一个函数，
 *  只需返回arr中任意一个局部最小出现的位置即可
 * @author wushijia
 *
 */
public class FindOneLessValueIndex {
	public static int findOneLessValueIndex(int[] arr){
		if(arr == null || arr.length < 1){
			return -1;
		}
		if(arr.length == 1 || arr[0] < arr[1]){//头
			return 0;
		}
		if(arr[arr.length-1] < arr[arr.length - 2]){//尾部
			return arr.length - 1;
		}
		//以上情况都不满足说明头和尾之间一定有局部最小位置
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while(left < right){
			mid = left + (right - left)/2;
			if(arr[mid] > arr[mid - 1]){//中间的比左边的大
				right = mid - 1;
			}else if(arr[mid] > arr[mid + 1]){//中间的比右边的大
				left = mid + 1;
			}else{//找到
				return mid;
			}
		}
		return left;
	}
}
