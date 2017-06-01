package algorithms;

import java.util.Stack;

/*
 * 一个栈中的元素类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只允许申请一个栈，可以申请新的变量，但是不能用额外的数据结构
 * 
 * -----------------------------------------------------------------
 * 具体思路：既然只能使用额外的一个栈，那么就将原栈中的数据从栈顶开始一个一个弹入辅助栈中，
 * 如果弹入的数据比辅助栈的栈顶小或者相等的话，则弹入，反之，则不弹入，
 * 并将辅助栈的元素从栈顶开始一个一个弹回原栈中(因为已经排好序了，不必担心回去时会乱)直到辅助栈栈顶元素大于或等于当前需要弹入的元素
 * 当原栈为空的时候，辅助栈中的元素的顺序从顶到底是按从小到大排的，此时再将其元素一个一个弹入原栈中，就完成了题目要求
 */
public class SortStack {
public static void Reverse(Stack<Integer> stackSort){
	Stack<Integer> stackHelp = new Stack<Integer>();//申请辅助栈
	while(!stackSort.isEmpty()){//将原栈中的元素弹入辅助栈直到为空
		int item = stackSort.pop();//将栈顶弹出
		//若辅助栈不为空，则判断辅助栈栈顶是否比item大，大或者等于则存入，小则将辅助栈中的元素一个一个弹入原栈，直到item相等或小于辅助栈顶
		while(!stackHelp.isEmpty() && item > stackHelp.peek()){
			stackSort.push(stackHelp.pop());
		}
		stackHelp.push(item);
	}
	while(!stackHelp.isEmpty()){//将排好序的栈中的元素一个一个存入原栈中
		stackSort.push(stackHelp.pop());
	}
	
 }
public static void main(String[] args) {//测试用例
	Stack<Integer> S1 = new Stack<Integer>();
	int[] num = new int[]{9,8,7,6,5,4,3,2,1};
	for(int i = 0;i < num.length;i++){
		S1.push(num[i]);
	}
	Reverse(S1);
	while(!S1.isEmpty()){
		System.out.println(S1.pop());
	}
}
}