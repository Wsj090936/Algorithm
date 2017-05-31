package algorithms;

import java.util.Stack;

//利用两个栈实现队列的基本功能 add,poll,peek
/*
 * 程序实现的原理是利用两个栈Stackpush与Stackpop，Stackpush负责将数据压入，
 * 当需要出队列的时候，将Stackpush中的栈顶元素全部弹入到Stackpop中，
 * 如果弹入之前Stackpop已经有元素了，就不需要弹入了，直接让Stackpop弹出即可，
 * 
 */
public class TwoStackQueue {
public static void main(String[] args) {
	StackQueue S1 = new StackQueue();
	int[] num = new int[]{1,2,3,4,5};//测试用例
	for(int i = 0;i<num.length;i++){
		S1.add(num[i]);
	}
	while(true){
		System.out.println(S1.poll());
	}
}
}
class StackQueue{
	Stack<Integer> Stackpush;
	Stack<Integer> Stackpop;
	StackQueue(){
		Stackpush = new Stack<Integer>();
		Stackpop = new Stack<Integer>();
	}
	public void add(int data){//入队列
		Stackpush.push(data);
	}
	public int poll(){//出队列
		if(Stackpush.empty()&&Stackpop.empty()){
			throw new RuntimeException("队列为空！");
		}else if(Stackpop.isEmpty()){//如果Stackpop为空，就可以往里面添加下一个元素，并弹出，若不为空，则直接弹出
			while(!Stackpush.empty()){
				Stackpop.push(Stackpush.pop());
			}
		}
		return Stackpop.pop();
	}
	public int peek(){
		if(Stackpush.empty()&&Stackpop.empty()){
			throw new RuntimeException("队列为空");
		}else if(Stackpop.empty()){//如果Stackpop中没有元素，则马上从Stackpush中弹入一个
			while(!Stackpush.empty()){
				Stackpop.push(Stackpush.pop());
			}
		}
		return Stackpop.peek();
	}
}