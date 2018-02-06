package sort;
/**
 * 归并排序
 * @author wushijia
 *
 */
public class S_04_MerageSort {
	public static void merageSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		merageSort1(arr,0,arr.length-1);
	}
	private static void merageSort1(int[] arr ,int l,int r){
		if(l == r){
			return;
		}
		int mid = (r-1)/2;
		merageSort1(arr,l,mid);
		merageSort1(arr,mid+1,r);
		merage(arr,l,mid,r);
	}
	private static void merage(int[] arr,int l,int m,int r){
		int[] help = new int[r-l+1];
		int ptr = l;//最左边的下标
		int cur = m+1;//mid右边的下标
		int i = 0;
		while(ptr <= m && cur <=r){
			help[i++] = arr[ptr] > arr[cur]?arr[cur++]:arr[ptr++];
		}
		while(ptr <= m){//如果一方还没遍历玩
			help[i++] = arr[ptr++];
		}
		while(cur <= m){
			help[i++] = arr[cur++];
		}
		for (i = 0;  i < help.length; i++) {
			arr[l+i] = help[i];
		}
	}
}
