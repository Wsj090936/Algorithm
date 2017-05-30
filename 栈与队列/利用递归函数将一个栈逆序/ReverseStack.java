package algorithms;
//利用递归实现栈的逆序
/*
 * 实现方式：利用两个递归函数，GetStackLast()递归函数实现将栈中的最底部元素返回出来，Reverse函数递归实现栈的逆序
 */
import java.util.Stack;

public class ReverseStack {
	public static int GetStackLast(Stack<Integer> S1){//递归返回栈底元素，其余元素从新压入
		int result = S1.pop();
		if(S1.empty()){//如果为空，就返回值
			return result;
		}else {
			int last = GetStackLast(S1);//开始递归
			S1.push(result);
			return last;
		}
		
	}
	public static void Reverse(Stack<Integer> S1){
		if(S1.empty()){
			return;
		}
		int i = GetStackLast(S1);
		Reverse(S1);
		S1.push(i);
	}
	public static void main(String[] args) {
		Stack<Integer> S1 = new Stack<Integer>();//测试用例
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0;i<num.length;i++){
			S1.push(num[i]);
		}
		Reverse(S1);
		while(!S1.empty()){
			System.out.println(S1.pop());
		}
	}
}
