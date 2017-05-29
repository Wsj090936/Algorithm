package algorithms;
/*
 * 写一个具有getMin()求最小栈元素的栈，可以使用基本栈 （难度小）
 */
import java.util.Stack;

public class StackGetmin {
public static void main(String[] args) {
	MyStack S1 = new MyStack();
	int[] num = new int[]{8,3,5,6,6,2,5,8,2,1,4,1};
	for(int i = 0;i<num.length;i++){
		S1.push(num[i]);
	}
	while(true){
		int value = S1.pop();
		System.out.println("栈顶元素"+value+"出栈");
		System.out.println("目前栈中的最小元素为:"+S1.getMin());
	}
}
}
class MyStack{
	private Stack<Integer> StackData;//数据栈
	private Stack<Integer> StackMin;//该栈中的元素由栈底到栈顶大小递减，存入时若待存入元素大于栈顶，则不入栈，若小于，则入栈，若相等，则也入栈
	public MyStack(){
		this.StackData = new Stack<Integer>();
		this.StackMin = new Stack<Integer>();
	}
	public void push(int data){//入栈
		if(this.StackMin.isEmpty()){//如果StackMin栈为空，不论该数多大，都入栈
			StackMin.push(data);
		}else if(data <= this.getMin()){//如果入栈的元素比当前栈中最小的元素还小，则存入StackMin栈中
				StackMin.push(data);
		}
		StackData.push(data);
	}
	public int pop(){//出栈
		if(StackData.isEmpty()){
			throw new RuntimeException("栈为空");
		}
		int value = StackData.pop();//将出栈元素存入自定义变量value中
		if(value == this.getMin()){//若出栈元素等于最小元素，则最小元素也出栈
			this.StackMin.pop();
		}
		return value;
	}
	public int getMin(){
		if(this.StackMin.isEmpty()){
			throw new RuntimeException("无最小值元素");
		}
		return this.StackMin.peek();//栈StackMin的栈顶元素即为当前栈中的最小元素
	}
}