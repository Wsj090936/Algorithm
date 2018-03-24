package dynamicProgramming;
/**
 * 换钱最少的货币数
 * 给定数组arr，arr中所有的值都为正数且不重复，每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定
 * 一个整数aim代表要找的钱数，求组成aim的最少货币数
 * @author wushijia
 *
 */
public class MinCoins {
	public static int minCoins1(int[] arr,int aim){
		if(arr == null || aim < 0){
			return -1;
		}
		int row = arr.length;
		int col = aim+1;
		int max = Integer.MAX_VALUE;//若找不开，就将值设置为max
		int[][] dp = new int[row][col];//dp[o...row][0]表示需要找的钱数为0时，需要0..row钱的张数
		for(int j = 1;j < col;j++){//dp[0][x]表示只能使用arr[0]的情况下找到x锁需要的arr[0]的张数
			dp[0][j] = max;
			if((j-arr[0] >= 0) && (dp[0][j-arr[0]] != max)){//初始化第一行
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int temp = 0;
		for(int i = 1;i < row;i++){
			for(int j = 1;j < col;j++){
				temp = max;
				if(j - arr[i] >= 0 && dp[i][j - arr[i]] != max){
					temp = dp[i][j - arr[i]] + 1;//只使用arr[i]的情况
				}
				dp[i][j] = Math.min(temp, dp[i - 1][j]);//dp[i - 1][j]表示完全不使用arr[i]的情况下表示的最小张数
			}
		}
		return dp[row - 1][aim] != max ? dp[row-1][aim] : -1;
	}
	public static int minCoins2(int[] arr,int aim){//优化版本
		if(arr == null || aim < 0){
			return -1;
		}
		int row = arr.length;
		int max = Integer.MAX_VALUE;
		int[] dp = new int[row];
		for(int j = 1;j <= aim;j++){
			dp[j] = max;
			if((j-arr[0] >= 0) && (dp[j-arr[0]] != max)){
				dp[j] = dp[j - arr[0]] + 1;
			}
		}
		int temp = 0;
		for(int i = 1;i < row;i++){
			for(int j = 1;j <= aim;j++){
				temp = max;
				if(j - arr[i] >= 0 && dp[j - arr[i]] != max){
					temp = dp[j - arr[i]] + 1;
				}
				dp[j] = Math.min(temp, dp[j]);
			}
		}
		return dp[aim] != max ? dp[aim] : -1;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{5,2,3};
		int aim = 20;
		System.out.println(minCoins1(arr,aim));
	}
}
