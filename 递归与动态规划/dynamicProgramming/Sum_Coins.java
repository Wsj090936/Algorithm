package dynamicProgramming;
/**
 * 给定数组arr，arr中所有的值都为正数切不重复，每个值代表一种面值的货币，每种
 * 面值的货币可以使用任意张，在给定一个aim代表要找的钱数。求换钱的方法总数
 * @author wushijia
 *
 */
public class Sum_Coins {
	public static int coins(int[] arr,int aim){
		if(arr == null || aim < 0){
			return 0;
		}
//		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr,aim);
	}

	private static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if(index == arr.length){
			res = aim == 0 ? 1 : 0;
		}else{
			for(int i = 0;arr[index]*i <= aim;i++){
				res += process1(arr,index+1,aim-arr[index]*i);
			}
		}
		return res;
	}
	
	private static int process1(int[] arr, int index, int aim,int[][] map) {//优化一
		int res = 0;
		if(index == arr.length){//此时说明已经找到最后一个数了
			res = aim == 0 ? 1 : 0;
		}else{
			int mapValue = 0;
			for(int i = 0;arr[index]*i <= aim;i++){
				mapValue = map[index + 1][aim-arr[index]*i];//计算下一步之前先查看之前是不是计算过了
				if(mapValue != 0){//计算过了
					res += mapValue == -1 ? 0 : mapValue;
				}else{//没有计算过
					res += process1(arr,index+1,aim-arr[index]*i,map);
				}
			}
		}
		map[index][aim] =  res == 0 ? -1 : res; //-1该步骤之前计算过，返回值为0. 而0表示没有计算过
		return res;
	}
	
	private static int process2(int[] arr,int aim){
		if(arr == null || aim < 0){
			return 0;
		}
		int row = arr.length;//
		int col = aim + 1;
		int[][] dp = new int[row][col];//第一行表示使用arr[0]时能够组成的小于等于aim的货币的钱数
									   //第一列表示使得钱数为0的方法数，很明显为1
		for(int i = 0;i < row;i++){//初始化第一列
			dp[i][0] = 1;
		}
		for(int j = 1;arr[0]*j <= aim;j++){//初始化第一行  比如arr[0]=5,那组只用5能够组成的倍数的方法只有一种
			dp[0][arr[0]*j] = 1;
		}
//		int num = 0;
		for(int i = 1;i < arr.length;i++){
			for(int j = 0;j <= aim;j++){//j就是想要找的钱数
/*				num = 0;
				for(int k = 0;j-arr[i]*k >= 0;k++){					
					num += dp[i - 1][j - arr[i]*k];//记录总方法数		
				}
				dp[i][j] = num;*/
				dp[i][j] = dp[i - 1][j];//完全不用arr[i]
				if(j - arr[i]>=0){
					dp[i][j] += dp[i][j - arr[i]];
				}
			}
		}
		return dp[row - 1][aim];
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{5,10,25,1};
		int aim = 15;
		System.out.println(coins(arr,15));
	}
}
