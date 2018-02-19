package array;
/**
 * 给出一个无序数组，求出需要排序的最短子数组长度
 * 时间复杂度为O(N)
 * @author wushijia
 *思路如下：
 *		首先从右遍历数组，记录出现的最小的数，该数的位置用noMinIndex记录(初始值为-1)，
 *将数组的最后一个元素记为min，每当遇到比min大的数，则说明此处需要调整，将noMinIndex的值变为该位置的下标
 *，然后将数组从左向右遍历i，用同样的方式记录需要交换的位置为noMaxIndex，最后将两数相减即可
 */
public class Aa_342 {
	public static int getMinLength(int[] arr){
		if(arr.length < 2 || arr == null){
			return 0;
		}
		int min = arr[arr.length - 1];
		int noMinIndex = -1;
		for(int i = arr.length - 2; i>=0 ;i-- ){
			if(arr[i] > min){
				noMinIndex = i;
			}else{
				min = Math.min(min, arr[i]);
			}
		}
		if(noMinIndex == -1){
			return 0;
		}
		int max = arr[0];
		int noMaxIndex = -1;
		for(int i = 1; i < arr.length;i++){
			if(arr[i] < max){
				noMaxIndex = i;
			}else{
				max = Math.max(max, arr[i]);
			}
		}
		if(noMaxIndex == -1){
			return 0;
		}
		return noMaxIndex - noMinIndex+1;
		
	}
	public static void main(String[] args) {
		int[] arr = new int[]{1,5,3,4,2,6,7};
		int min = getMinLength(arr);
		System.out.println(min);
	}
}
