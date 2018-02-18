package array;
/**
 * 寻找到数组中最小的k个数
 * 普通的解法是利用快速排序，然后返回数组的前k个数，但是这样的话时间复杂度为O(N*logN)
 * 利用堆的话时间复杂度课以降为O(N*logK)
 * 利用了堆排序，始终维护一个长度为k的大根堆，遍历数组，每当数组中的某一个数比堆中的根小时，就交换，然后调整堆
 * 最后输出堆即可
 * @author wushijia
 *
 */
public class Aa_336 {
	public static int[] getMinNums(int[] arr,int k){
		if(k < 1 || k > arr.length){
			return arr;
		}
		int[] heapArr = new int[k];//建立堆  大根堆
		for (int i = 0; i != k; i++) {
			heapInsert(heapArr,arr[i],i);
		}
		for(int i = k;i != arr.length;i++){//由于堆中已经放入了前k个元素，因此这里从k开始
			if(arr[i] < heapArr[0]){
				heapArr[0] = arr[i];
				heapify(heapArr,0,k);
			}
		}
		return heapArr;
	}
	
	private static void heapify(int[] heapArr, int index, int size) {
		int left = index*2 + 1;//左孩子
		int right = index*2 + 2;
		int largest = index;
		while(left < size){//满足该条件才能进行调整
			if(heapArr[left] > heapArr[index]){
				largest = left;
			}
			if(right < size && heapArr[right] > heapArr[largest]){
				largest = right;
			}
			if(largest != index){
				swap(heapArr,largest,index);
			}else{
				break;
			}
			index = largest;
			left = index*2 + 1;
			right = index*2 + 2;
		}
		
	}

	private static void heapInsert(int[] heapArr,int value,int index){
		heapArr[index] = value;
		while(index != 0){
			int parent = (index-1)/2;
			if(heapArr[index] > heapArr[parent]){//调整堆
				swap(heapArr,index,parent);
				index = parent;
			}else{
				break;
			}
		}
	}

	private static void swap(int[] arr,int m,int n){
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{3,6,7,9,2,40,50,17};
		int[] minNums = getMinNums(arr,4);
		for (int i : minNums) {
			System.out.println(i);
		}
	}
}
