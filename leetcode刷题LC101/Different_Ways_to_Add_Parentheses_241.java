package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


	Example 1
	Input: "2-1-1".
	
	((2-1)-1) = 0
	(2-(1-1)) = 2
	Output: [0, 2]
	
	
	Example 2
	Input: "2*3-4*5"
	
	(2*(3-(4*5))) = -34
	((2*3)-(4*5)) = -14
	((2*(3-4))*5) = -10
	(2*((3-4)*5)) = -10
	(((2*3)-4)*5) = 10
	Output: [-34, -14, -10, -10, 10]
 * @author wushijia
 *
 */
public class Different_Ways_to_Add_Parentheses_241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < input.length();i++){
            if(input.charAt(i) == '-' ||
               input.charAt(i) == '+' ||
               input.charAt(i) == '*'){
                String left = input.substring(0,i);//将字符串从第一个运算符开始分割
                String right = input.substring(i + 1);
                List<Integer> leftlist = diffWaysToCompute(left);//左边部分得到的值
                List<Integer> rightlist = diffWaysToCompute(right);//右边部分得到的值
                for(Integer l : leftlist){
                    for(Integer r : rightlist){
                        int e = 0;
                        switch(input.charAt(i)){
                            case '-': e = l - r;
                                break;
                            case '+': e = l + r;
                                break;
                            case '*': e = l * r;
                                break;
                        }
                        res.add(e);
                    }
                }
            }
        }
        if(res.size() == 0){//如果循环完成结果集的大小未0，则说明为整数
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
