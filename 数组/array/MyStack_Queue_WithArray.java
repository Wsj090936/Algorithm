package array;


/**
 * 用一个数组分别实现栈和队列结构
 * @author wushijia
 *
 */
public class MyStack_Queue_WithArray {
	public static class ArrayStack{
		public Integer[] arr;
		public int index;//表示栈顶元素的上面一个位置
		public ArrayStack(Integer len) {
			if(len <= 0){
				throw new IllegalArgumentException("the stack size is less than 1");
			}
			arr = new Integer[len];
			index = 0;
		}
		public void push(Integer data){
			if(arr.length == index){
				throw new IllegalArgumentException("the stack is full");
			}
			arr[index++] = data;
		}
		public Integer peek(){
			if(index == 0){
				return null;
			}
			return arr[index-1];
		}
		public Integer pop(){
			if(index == 0){
				throw new ArrayIndexOutOfBoundsException("the stack is empty");
			}
			return arr[--index];
		}
	}
	public static class ArrayQueue{
		public Integer[] arr;
		public Integer size;//表示队列当前的大小
		public Integer end;//负责添加的指针
		public Integer start;//负责弹出数的指针
		public ArrayQueue(Integer len){
			if(len <= 0){
				throw new IllegalArgumentException("the queue size is less than 1");
			}
			arr = new Integer[len];
			this.size = 0;
			this.end = 0;
			this.start = 0;
		}
		public void add(Integer data){
			if(size == arr.length){
				throw new IllegalArgumentException("the queue is full");
				
			}
			size++;
			arr[end] = data;
			end = end == arr.length-1 ? 0 : end+1;//达到数组长度就循环回去
			
		}
		public Integer peek(){
			if(size == 0){
				return null;
			}
			return arr[start];
		}
		public Integer poll(){
			if(size == 0){
				throw new IllegalArgumentException("the queue is empty");
			}
			size--;
			int res = arr[start];
			start = start == arr.length-1 ? 0 : start+1;
			return res;
		}
	}
}
