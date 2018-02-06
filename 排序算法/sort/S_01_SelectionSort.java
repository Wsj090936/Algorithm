package sort;
/**
 * —°‘Ò≈≈–Ú
 * @author wushijia
 *
 */
public class S_01_SelectionSort {
	
	public static void selectionSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		for(int i = 0;i < arr.length;i++){
			int minIndex = i;
			for(int j = i+1;j < arr.length;j++){
				if(arr[j] < arr[i])
					minIndex = j;
			}
			swap(arr,minIndex,i);
		}
	}
	
	private static void swap(int[] arr,int j,int k){
		int temp = 0;
		temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
	
}
