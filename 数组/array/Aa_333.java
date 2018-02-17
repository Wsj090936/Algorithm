package array;
/**
 * 将一个二维数组反转90度
 * p333
 * 
 * @author wushijia
 *
 */
public class Aa_333 {
	public static void reverseArray(int[][] arr){
		int lx = 0;
		int ly = 0;
		int rx = arr.length-1;
		int ry = arr[0].length-1;
		while(lx < rx){
			printReverse(arr,lx++,ly++,rx--,ry--);
		}
	}
	private static void printReverse(int[][] arr,int lx,int ly,int rx,int ry){
		int times = ry-ly;//次数
		int temp = 0;
		for(int i = 0;i < times;i++){
			temp = arr[lx][ly + i];
			arr[lx][ly+i] = arr[rx-i][ly];
			arr[rx-i][ly] = arr[rx][ry-i];
			arr[rx][ry-i] = arr[lx+i][ry];
			arr[lx+i][ly] = temp;
		}
	}
}
