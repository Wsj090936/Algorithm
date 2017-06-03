package algorithms;

import java.util.LinkedList;

/*
 * 生成窗口最大值数组
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右滑动一个位置，如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值
 * 请实现一个函数：
 * 	|-------输入一个整型数组arr，窗口大小为w
 * 	|-------输出一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值
 * 	|-------要求时间复杂度为O(n),不能为O(n*w)
 * *******************************************************************************************************************************************
 * 分析:
 * 		方法一:传统的方法，比较并找出每一个窗口中最大的那个数，然后存入res数组中，这是最先想到的方法，但是时间复杂度为O(n*w)
 * 方法二:利用现有的数据结构LinkedList(双端队列)进行滑动窗口最大值的查找
 * 				----------具体实现方法如下---------
 * 利用for循环先将arr数组的第一个元素的下标放入双端队列中，再将第二个也存入，存入之前先比较以下当前元素是否大于队尾下标所对应的值，若大于，则队尾元素弹出，
 * 然后再次和队尾下标对应的值作比较，重复刚才的操作，直到队尾下标对应的值大于当前元素，若小于，则直接从队尾存入当前元素的下标,
 * 刚开始时循环三次之后第一个最大值(队首下标对应的数组元素)将被存入返回数组，以后每循环一次就有一个最大值被存入数组，然后每当队首下标peekFirst等于
 * 当前元素下标i减去窗口大小w时从队列中弹出(过期了)
 * 
 */
public class getMaxWindow {
public static void main(String[] args){
	int[] arr = new int[]{4,3,5,4,3,3,6,7};
	int[] res = getMaxArray(arr,3);
	for(int i = 0;i<res.length;i++){
		System.out.println(res[i]);
	}
}
	public static int[] getMaxArray(int[] arr,int w){
		if(arr==null || arr.length < w || w<1){
			System.out.println("数组为空或滑动窗口长度值不对");
			return null;
		}
		LinkedList<Integer> MaxList = new LinkedList<Integer>();//存有数组下标的双端队列
		int[] res = new int[arr.length-w+1];//返回数组
		int index = 0;//用来记录返回数组的下标位置
		for(int i = 0;i<arr.length;i++){
			while(!MaxList.isEmpty() && arr[MaxList.peekLast()] <= arr[i]){//如果队列的队尾下标对应的元素小于数组的当前下标对应的元素，则队尾元素弹出，
				MaxList.pollLast();
			}
		MaxList.addLast(i);//当前元素的下标从队尾入队列
		if(MaxList.peekFirst() == i-w){//当队首下标为当前元素下标减去窗口大小时，队首元素下标过期，弹出队列
			MaxList.pollFirst();
		}
		if(i >= w-1){//刚开始时循环三次之后第一个最大值(队首元素)将被存入数组，以后每循环一次就有一个最大值被存入数组
			res[index++] = arr[MaxList.peekFirst()];
		}
	  }
		return res;
	}
}
