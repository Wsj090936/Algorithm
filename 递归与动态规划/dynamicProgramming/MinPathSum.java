package dynamicProgramming;





/**
 * 矩阵的最小路径和：给出一个二维矩阵，从左上角开始走，每次只能走下边或者右边，
 * 求到最下角的最短路径和
 * @author wushijia
 *
 */
public class MinPathSum {
	public static int minPathSum1(int[][] arr){
		if(arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0){
			return 0;
		}
		int row = arr.length;
		int col = arr[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = arr[0][0];
		for(int i = 1; i < row;i++){//先计算出到达矩阵第一列上所有数的最短路径，直接是各个数相加
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		}
		for(int j = 1;j < col;j++){//第一行
			dp[0][j] = dp[0][j - 1] + arr[0][j];
		}
		//然后分别计算每一格的路径
		for(int i = 1; i < row;i++){
			for(int j = 1;j < col;j++){
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
			}
		}
		return dp[row-1][col-1];
	}
	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,3,5,9},
								  {8,1,3,4},
								  {5,0,6,1},
								  {8,8,4,0}};
		System.out.println(minPathSum1(arr));
	}
}
