package dynamicProgramming;
/**
 * 换钱最少的货币数
 * 给定数组arr，arr中所有的值都为正数且不重复，每个值代表一种面值的货币，每种面值的货币可以使用一张，再给定
 * 一个整数aim代表要找的钱数，求组成aim的最少货币数
 * @author wushijia
 *
 */
public class MinCoins_2 {
	public static int minCoins2(int[] arr,int aim){
		if(arr == null || aim < 0 || arr.length == 0){
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];
		//初始化第一行
		for(int i = 0;i <= aim;i++){
			dp[0][i] = max;
		}
		if(arr[0] < aim){
			dp[0][arr[0]] = 1;
		}
		int left = 0;
		for(int i = 1;i < n;i++){//行
			for(int j = 1;i <= aim;j++){//列
				left = max;
				if(j-arr[i] >=0 && dp[i-1][j-arr[i]] != max){
					left = dp[i-1][j-arr[i]]+1;
				}
				dp[i][j] = Math.min(left, dp[i-1][j]);
			}
		}
		return dp[n-1][aim] != max?dp[n-1][aim] : -1;
	}
}
