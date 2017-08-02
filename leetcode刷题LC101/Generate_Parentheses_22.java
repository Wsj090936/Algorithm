package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:
	
	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]
 * @author wushijia
 *
 */
public class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        DFS(list ,"",0,0,n);
        return list;
    }
    private void DFS(List<String> list ,String str,int left,int right,int n){
        if(str.length() == n*2){
            list.add(str);
            return;
        }
        if(left < n){
            DFS(list,str + "(",left +1 ,right,n);
        }
        if(right < left){
            DFS(list,str + ")",left,right + 1,n);
        }
    } 
}
