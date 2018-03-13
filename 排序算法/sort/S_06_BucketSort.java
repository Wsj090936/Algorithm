package sort;
/**
 * 桶排序：条件是仅仅需要排序的数为正数时
 * 计数排序
 * @author wushijia
 *
 */
public class S_06_BucketSort {
	public static void bucketSort(int[] arr){
		if(arr.length < 2 || arr == null){
			return;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<arr.length;i++){
			max = Math.max(max, arr[i]);
		}
		int[] bucket = new int[max];
		for(int i = 0;i<arr.length;i++){
			bucket[arr[i]]++;
		}
		int j = 0;
		for(int k = 0;k<arr.length;k++){
			while(bucket[k]-- > 0){
				arr[j++] = k;
			}
		}
	}
}
