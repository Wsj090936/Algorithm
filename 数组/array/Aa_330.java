package array;
/**
 * 求一个数组中最小值和最大值的差值，要求时间复杂度为O(N)
 * 利用桶排序，每个桶负责装入一定范围上的数，然后求解
 * 桶的大小是数组长度+1
 * @author wushijia
 *
 */
public class Aa_330 {
	public static int getRes(int[] arr){
		if(arr == null || arr.length<2){
			return 0;
		}
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0;i < len;i++){//找到最大值和最小值
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		if(min == max){
			return 0;
		}
		boolean[] hasNum = new boolean[len+1];
		int[] maxs = new int[len+1];//记录最大数的数组
		int[] mins = new int[len+1];//记录最小数的数组
		int bid = 0;
		for(int i = 0;i<len;i++){
			bid = bucketNum(arr[i],len,max,min);
			maxs[bid] = hasNum[bid]?Math.max(maxs[bid], arr[i]):arr[i];
			mins[bid] = hasNum[bid]?Math.min(mins[bid], arr[i]):arr[i];
			hasNum[bid] = true;
		}
		int res = 0;
		int lastMax = maxs[0];//开始时的最前的最大数一定在0号桶中
		for(int i = 1;i <= len;i++){
			if(hasNum[i]){
				res = Math.max(res,mins[i]-lastMax);//后一个非空桶的最小值减去前一个非空桶的最大值
				lastMax = maxs[i];//完后改变前一个非空桶的最大值
			}
		}
		return res;
	}
	private static int bucketNum(int num,int len,int max,int min){
		return ((num-min)*len/(max-min));
	}
}
