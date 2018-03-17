package stack;

import java.util.Stack;

/**
 * 用栈实现队列结构
 * @author wushijia
 *
 */
public class MyQueue_WithStack {
	private Stack<Integer> pushStack = new Stack<>();
	private Stack<Integer> popStack = new Stack<>();
	
	public void add(Integer item){
		pushStack.push(item);
	}
	public Integer poll(){
		if(pushStack.isEmpty() && popStack.isEmpty()){
			throw new RuntimeException("the queue is Empty");
		}
			createPop();
			return popStack.pop();
	}
	public Integer peek(){
		if(pushStack.isEmpty() && popStack.isEmpty()){
			throw new RuntimeException("the queue is Empty");
		}
		createPop();
		return popStack.peek();
	}
	private void createPop() {
		if(popStack.isEmpty()){
			while(!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
		}
	}
}
