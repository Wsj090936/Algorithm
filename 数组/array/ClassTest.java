package array;

public class ClassTest {
	/**
	 * 转圈打印二维矩阵
	 * @param arr
	 */
	public static void fun1(int[][] arr){
		int lx = 0;
		int ly = 0;
		int rx = arr.length - 1;
		int ry = arr[0].length - 1;
		while(lx <= rx && ly <= ry){
			printArryay(arr,lx++,ly++,rx--,ry--);
		}
	}

	private static void printArryay(int[][] arr, int lx, int ly, int rx, int ry) {
		if(lx == rx){//只有一行时
			for(int i = 0;i<=ry;i++){
				System.out.println(arr[lx][i]+" ");
			}
		}else if(ly == ry){//当只有一列时
			for(int i = 0;i<=rx;i++){
				System.out.println(arr[i][ly]+" ");
			}
		}else{//其他情况
			int cur = lx;
			int ptr = ly;
			while(ptr != ry){
				System.out.println(arr[lx][ptr++]+" ");
			}
			while(cur != rx){
				System.out.println(arr[cur++][ry]+" ");
			}
			while(ptr != ly){
				System.out.println(arr[rx][ptr--]+" ");
			}
			while(cur != lx){
				System.out.println(arr[cur--][ly]+" ");
			}
		}
	}
	
	
	/**
	 * "之"字形打印矩阵
	 * @param arr
	 */
	public void fun2(int[][] arr){
		int lx = 0;//右边的指针
		int ly = 0;
		int rx = 0;//左边的指针
		int ry = 0;
		boolean flag = false;
		int endx = arr.length-1;
		int endy = arr[0].length - 1;
		while(lx <= endx){
			printA(arr,lx,ly,rx,ry,flag);
			lx = ly==endy?lx+1:lx;
			ly = ly==endy?ly:ly+1;
			ry = rx==endx?ry++:ry;
			rx = rx==endx?rx:rx++;
			flag = !flag;
		}
	}

	private void printA(int[][] arr, int lx, int ly, int rx, int ry, boolean flag) {
		if(flag){//从上到下
			while(lx <= rx){
				System.out.println(arr[lx++][ly--]+" ");
			}
		}else{//从下到上
			while(rx >= lx){
				System.out.println(arr[rx--][ry++]+" ");
			}
		}
	}
}
