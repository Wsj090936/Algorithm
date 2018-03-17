package stack;

import java.util.Stack;
/**
 * 实现一个具有getMin()功能的栈
 * 要求getMin()的时间复杂度为O(1)
 * @author wushijia
 *
 */
public class GetMinStack {
	private Stack<Integer> dataStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	public void push(Integer value){
		if(minStack.isEmpty()){
			minStack.push(value);
		}else if(value < getMin()){//如果当前插入的数小于栈中最小元素
			minStack.push(value);
		}else{//如果插入的数大于等于最小值
			int newMin = minStack.peek();
			this.minStack.push(newMin);
		}
		this.dataStack.push(value);
	}
	public Integer pop(){
		if(this.dataStack.isEmpty()){
			throw new RuntimeException("the stack is empty");
		}
		this.minStack.pop();
		return this.dataStack.pop();
	}
	public Integer getMin(){
		if(minStack.isEmpty()){
			throw new RuntimeException("the stack is empty");
		}
		return minStack.peek();
	}
}
