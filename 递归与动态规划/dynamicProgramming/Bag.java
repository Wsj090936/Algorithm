package dynamicProgramming;
/**
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的 重量，v[i]表示第i件商品的价值。
 *  再给定一个整数bag，要求你挑选商品的重量加起来一定不能超 过bag，返回满足这个条件下，你能获得的最大价值
 * @author wushijia
 *
 */
public class Bag {
	public static int getMaxValue(int[] weight,int[] value,int bag){
		return getMax(weight,value,0,0,bag);
	}
	private static int getMax(int[] weight,int[] value,int i,int nowWeight,int bag){
		if(nowWeight > bag){
			return Integer.MIN_VALUE;
		}
		if(i == weight.length){//到达了末尾,递归返回
			return 0;
		}
		return Math.max(getMax(weight,value,i + 1,nowWeight,bag), //不选第i个
						value[i] + getMax(weight,value,i + 1,weight[i] + nowWeight,bag));//选择第i个
	}
	public static int getMaxValue2(int[] weight,int[] value,int bag){
		int[][] dp = new int[weight.length + 1][bag + 1];
		for(int i = weight.length-1;i>=0;i--){
			for(int j = bag;j>=0;j--){
				dp[i][j] = dp[i + 1][j];//不选i,j表示当前重量
				if(j + weight[i] <= bag){
					dp[i][j] = Math.max(dp[i][j], value[i] + dp[i + 1][j + weight[i]]);
				}
			}
		}
		return dp[0][0];
	}
}
