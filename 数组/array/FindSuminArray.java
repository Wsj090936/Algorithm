package array;
/**
 * 在一个有序的二维数组中，输入一个n，若n存在，返回true，若不存在，返回false
 * 注意 ：有序的二维数组表示行和列都是有序的
 * @author wushijia
 *
 */
public class FindSuminArray {
	public static boolean find(int[][] arr,int dst){
		int x = 0;
		int y = arr[0].length - 1;
		while(x < arr.length && y > -1){
			if(arr[x][y] == dst){
				return true;
			}else if(arr[x][y] > dst){
				y--;
			}else{
				x++;
			}
		}
		return false;
	}
}
