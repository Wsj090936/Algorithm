package algorithms;
/*
 * 问题：Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
		The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	该问题为一个括号匹配问题，用栈来做
 */
public class ValidParentheses_20 {
	public static void main(String[] args) {
		String s = "(";	
		System.out.println(isValid(s));
	}
	public static boolean isValid(String s) {
		int top = 0 ;//栈顶指针
		char e = 0 ;//用来存放字符串中某一字符的变量
		char[] stack = new char[s.length()+1];//自定义一个栈
		for(int i = 0 ; s != null && i < s.length() ; ++i){
				e = s.charAt(i);
				if(e == '(' || e == '[' || e == '{'){
					stack[++top] = e;
				}else if (top == 0){
					return false;
				}else{
				if((stack[top] == '(' && e == ')') || (stack[top] == '[' && e == ']') || (stack[top] == '{' && e == '}')){
					top--;//当匹配了一对括号时  就将top减一  表示弹出栈
				}else {
					return false;
				}
			}
					
		}
		return top == 0;
	}
  }


