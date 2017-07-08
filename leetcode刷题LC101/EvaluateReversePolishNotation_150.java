package algorithms;
/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

	Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	
	Some examples:
	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	  Äæ²¨À¼¼ÆËãÆ÷
 */

public class EvaluateReversePolishNotation_150 {
	public static void main(String[] args) {
		String[] A = new String[]{"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(A));
	}
	public static int evalRPN(String[] tokens){
		int top = 0;//Õ»¶¥Ö¸Õë
		int[] stack = new int[tokens.length+1];
		for(int i = 0; i < tokens.length;i++){
			Integer e = null;
			try {
				e = Integer.parseInt(tokens[i]);
			} catch (NumberFormatException e1) {
			}
			if(e != null){
				stack[++top] = e;
			}else{
				int a = stack[top-1];
                int b = stack[top];
                switch(tokens[i].charAt(0)){
                    case '*':
                        stack[--top] = a*b;
                        break;
                    case '/':
                        stack[--top] = a/b;
                        break;
                    case '+':
                        stack[--top] = a+b;
                        break;
                    case '-':
                        stack[--top] = a-b;
                        break;
			}
		}
	}
		return stack[1];
  }
}