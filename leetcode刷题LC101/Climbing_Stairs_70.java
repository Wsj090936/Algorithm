package algorithms;
/**
 *  You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	Note: Given n will be a positive integer.
 * @author wushijia
 *上楼梯问题，分析一个下可以得出是一个初始值为1和2的斐波那契数列问题
 */
public class Climbing_Stairs_70 {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2){
            return n;
        }
        int one = 1;
        int two = 2;
        int res = 0;
        for(int i = 2;i < n;i++){//初始值为1和2的斐波那契数列
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}
