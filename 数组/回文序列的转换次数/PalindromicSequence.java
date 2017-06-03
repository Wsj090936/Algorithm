package algorithms;

import java.util.Scanner;

import org.junit.Test;

/*
 * 	如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如： 
	{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列, 
	{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。 
	现在给出一个数字序列，允许使用一种转换操作： 
	选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。 
	现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列
	输入描述: 
	输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50) 
	第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
	
	输出描述: 
	输出一个数，表示最少需要的转换次数
	
	输入例子: 
	4 
	1 1 1 3
	
	输出例子: 
	2
 */
public class PalindromicSequence {
public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//输入的第一个数为序列中数字的个数
		int[] arr = new int[n];//数组的空间为序列中数字的个数
		for(int i = 0;i<n;i++){
			arr[i] = scanner.nextInt();//建立数组
		}
		scanner.close();
		int times = 0;//记录转换次数
		int start = 0;//数组首个元素下标
		int end = n - 1;//数组最后一个元素下标
		while(start<end){
			if(arr[start] < arr[end]){//当首元素小于尾元素
				arr[++start] = arr[start] + arr[start + 1];//将首元素后面的元素替换
				times++;
			}else if(arr[start] > arr[end]){//当首元素大于尾元素
				arr[--end] = arr[end] + arr[end+1];//将尾元素前面的元素替换
				times++;
			}else{
				start++;
				end--;
			}
		}
		System.out.println(times);
	}
}
