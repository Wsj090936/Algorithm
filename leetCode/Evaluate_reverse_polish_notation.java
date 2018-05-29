package leetCode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

  Valid operators are+,-,*,/. Each operand may be an integer or another expression.
  Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author wushijia
 *
 */
public class Evaluate_reverse_polish_notation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        for(int v = 0;v < tokens.length;v++){
        	if(stack.size() >= 2){
        		i = stack.pop();
        		j = stack.pop();
        	}
        	if(tokens[v].equals("+") ){
        		stack.push(j + i);
        	}else if(tokens[v].equals("/")){
        		stack.push(j/i);
        	}else if(tokens[v].equals("-")){
        		stack.push(j - i);
        	}else if(tokens[v].equals("*")){
        		stack.push(j * i);
        	}else{
        		stack.push(j);
        		stack.push(i);
        		stack.push(Integer.parseInt(tokens[v]));
        	}
        }
        return stack.pop();
    }
    public static void main(String[] args) {
		String[] strs = new String[]{"4", "13", "5", "/", "+"};
		int i = evalRPN(strs);
		System.out.println(i);
	}
}
