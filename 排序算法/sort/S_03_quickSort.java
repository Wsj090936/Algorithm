package sort;

public class S_03_quickSort {
	
	public static void quickSort(int[] arr){
		if(arr == null || arr.length < 2){
			return ;
		}
		quickSort1(arr,0,arr.length-1);
	}
	
	public static void quickSort1(int[] arr,int l,int r){
		if(l<r){
			swap(arr,l+(int)(Math.random()*(r-l+1)),r);//每次随机取一个位置上的数作为基准 l + (int) (Math.random() * (r - l + 1))
			int[] p = partition(arr,l,r);
			quickSort1(arr,l,p[0] - 1);
			quickSort1(arr,p[1]+1,r);
		} 
	}
	
	public static int[] partition(int[] arr,int l,int r){
		int less = l - 1;
		int more = r;
		while(l < more){
			if(arr[l] < arr[r]){
				swap(arr,++less,l++);
			}else if(arr[l] > arr[r]){
				swap(arr,--more,l);
			}else{
				l++;
			}
		}
		swap(arr,more,r);//将基准放到中间位置
		return new int[]{less + 1,more};//等于区域的下标
	}

	private static void swap(int[] arr,int j,int k){
		int temp = 0;
		temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{9,12,4,8,6,4,3,6};
		quickSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			
		}
	}
}
