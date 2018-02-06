package sort;

public class S_02_InsertSort {
	
	public static void insertSort(int[] arr){
		if(arr == null || arr.length < 2){
			return;
		}
		for(int i = 1;i < arr.length;i++){
			for(int j = i - 1;j>=0 && arr[j] > arr[j+1];j--){
				swap(arr,j,j+1);
			}
/*			for(int k = i -1;k>=0;k--){//比上面的那个要耗费一点时间
				if(arr[k] > arr[k+1]){
					swap(arr,k,k+1);
				}
			}*/
		}
		
	}
	
	private static void swap(int[] arr,int j,int k){
		int temp = 0;
		temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
}
