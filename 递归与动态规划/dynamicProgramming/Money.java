package dynamicProgramming;
/**
 * 给一个整数数组，和一个整数数aim，要求用数组中的几个数(每个数只能用一次)，组成这个aim，能组成就返回true，不能就返回false
 * @author wushijia
 *
 */
public class Money {
	public static void money(int[] arr,int aim){
		diguiMoney(arr,aim,0,0);
	}

	private static boolean diguiMoney(int[] arr, int aim, int i, int sum) {
		if(i == arr.length){
			return sum == aim;
		}
		return diguiMoney(arr,aim,i + 1,sum) || diguiMoney(arr,aim,i + 1,sum + arr[i]);
	}
	
	public static boolean money1(int[] arr,int aim){//由递归推来的
		boolean[][]dp = new boolean[arr.length + 1][aim + 1];
		for(int i = 0;i < arr.length;i++){
			dp[i][aim] = true;//当sum==aim时，才为true
		}
		for(int i = arr.length - 1;i >= 0;i--){//行
			for(int j = aim - 1; j > 0;j--){//列
				dp[i][j] = dp[i + 1][aim];//表示当前状态,j就是sum的值
				if(j + arr[i] <= aim){
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}
}
