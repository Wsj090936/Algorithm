package algorithms;
/**
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	
	The number of ways decoding "12" is 2.
 * @author wushijia
 *注意单双数的判断即可
 */
public class Decode_Ways_91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;//判断第一个数字是否为0
        for(int i = 2;i <= n;i++){
            int one = Integer.valueOf(s.substring(i - 1,i));//数字为单数
            int two = Integer.valueOf(s.substring(i - 2,i));//数字为双数
            if(one >= 1 && one <= 9){
                dp[i] = dp[i] + dp[i - 1];
            }
            if(two >= 10 && two <= 26){
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
