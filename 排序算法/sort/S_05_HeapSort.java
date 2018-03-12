package sort;
/**
 * 堆排序：构建大根堆，排出从小到大的数
 * 注意这里用数组表示堆
 * 		 7 8 9 10 11 12
 * 下标：0 1 2  3  4  5
 * 	组成的堆如下
 * 				7
 * 			8		9
 * 		  10 11   12
 * @author wushijia
 *
 */
public class S_05_HeapSort {
	public static void heapSort(int[] arr){
		if(arr == null || arr.length<2){
			return;
		}
		for(int i = 0;i < arr.length;i++){
			heapInsert(arr,i);
		}
		int size = arr.length;//堆的大小
		swap(arr,0,--size);
		while(size > 0){
			heapfiy(arr,0,size);//开始排序
			swap(arr,0,--size);//将排好的放在树的末端
		}
	}

	private static void heapfiy(int[] arr, int index, int size) {//排序过程
		int left = index * 2 + 1;//取到当前节点的左孩子
		while(left < size){
			int largest = (left + 1) < size && arr[left +1] > arr[left]? left+1 :left;//判断左右两个节点哪个大，取较大的哪个
			largest = arr[largest] > arr[index]?largest : index;//比较当前索引和最大索引的值
			if(largest == index){
				break;
			}
			swap(arr,largest,index);
			index = largest;//然后从交换的位置开始继续调整
			left = index * 2 + 1;//改变左孩子
		}
	}

	private static void heapInsert(int[] arr,int index) {
		while(arr[index] > arr[(index-1)/2]){//每次与自己的父节点进行比较
			swap(arr,index,(index-1)/2);
			index = (index-1)/2;
		}
	}
	private static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{5,10,7,0,3,8};
		heapSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
