package practice;
/**
 * 求小和问题：
 * 		给定一个数组，求出该数组中每一个数的左边比他小的数，将它们加起来，返回
 * @author wushijia
 *
 */
public class SmallSum {
	public static int smallSum(int[] arr){
		if(arr == null || arr.length < 2){
			return 0;
		}
		return merageSort(arr,0,arr.length - 1);
	}
	private static int merageSort(int[] arr,int l,int r){
		if(l == r){
			return 0;
		}
		int mid = l + ((r-l) >> 2);
		return merageSort(arr,l,mid) + merageSort(arr,mid+1,r) + merage(arr,l,mid,r);
	}
	private static int merage(int[] arr,int l,int mid,int r){
		int[] help = new int[r-l+1];
		int i = 0;//help数组的下标
		int p1 = l;
		int p2 = mid + 1;
		int res = 0;
		while(p1 <= mid && p2 <= r){
			res += arr[p1] < arr[p2]?(r - p2 + 1)*arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= mid){
			help[i++] = arr[p1++];
		}
		while(p2 <= r){
			help[i++] = arr[p2++];
		}
		for(i = 0;i < help.length;i++){//将排好序的部分重新填入arr
			arr[l+i] = help[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{4,1,3,5,0,6};
		int sum = smallSum(arr);
		System.out.println(sum);
	}
}
