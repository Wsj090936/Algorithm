package algorithms;

import java.util.List;
/**
 *  Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
	
	UPDATE (2017/1/4):
	The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 * @author wushijia
 *动态规划
 */
public class Word_Break_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for(int i = 1;i <= s.length();i++){
            for(int j = 0;j < i;j++){
                if(res[j] && wordDict.contains(s.substring(j,i))){//之前的可分并且当前的可分，就为true，不然的话运行结果不对
                    res[i] = true;
                    break;//只要找到一个就break
                }
            }
        }
        return res[s.length()];
    }
}
