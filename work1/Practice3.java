package work1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.net/questionTerminal/d2cced737eb54a3aa550f53bb3cc19d0
来源：牛客网

某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，
每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，
请实现一个算法选择其中一部分客人，使得总预计消费金额最大 
输入描述:
输入包括m+2行。 
第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 
第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。 
接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 * @author wushijia
 *
 *思路：将桌子大小升序排序，将客人的花费资金按照降序排序，然后每次选能够招待的并且花费最大的顾客即可
 *
 */
public class Practice3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] table = new int[n];//桌子
		for (int i = 0; i < n; i++) {
			table[i] = scanner.nextInt();
		}
		int[][] cus = new int[m][2];//客人
		for (int j = 0; j < m; j++) {
			cus[j][0] = scanner.nextInt();
			cus[j][1] = scanner.nextInt();
		}
		Arrays.sort(table);
		Arrays.sort(cus,new Comparator<int[]>() {//降序排序

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
			
		});
		boolean[] tableb = new boolean[n];
		long res = 0l;
		for(int i = 0;i<m;i++){
			if(cus[i][0] > table[n-1])//如果顾客人数大于最大的桌子，那就忽略这一批顾客
				continue;
			//先找出最能适合这一批顾客的桌子
			int can = bs(table,cus[i][0]);
			while(can<n && tableb[can]==true){//当桌子被占用时
				can++;
			}
			if(can < n){//如果找到合适的桌子
				res = res + cus[i][1];
				tableb[can] = true;
			}
		}
		scanner.close();
		System.out.println(res);
	}
	private static int bs(int[] arr,int target){//找到大于或者等于顾客人数的桌子
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while(low < high){
			mid = low + ((high-low)/2);
			if(arr[mid] >= target){
				high = mid;
			}else{
				low = mid + 1;
			}
		}
		return low;
	}
}
