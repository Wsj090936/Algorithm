package other;
/**
 * 随时找到数据流的中位数
【题目】 有一个源源不断地吐出整数的数据流，假设你有足够的空间来 保存吐出的数。
请设计一个名叫MedianHolder的结构， MedianHolder可以随时取得之前吐出所有数的中位数。
【要求】 1．如果MedianHolder已经保存了吐出的N个数，那么任意时刻 将一个新数加入到MedianHolder的过程，
其时间复杂度是 O(logN)。
 		2．取得已经吐出的N个数整体的中位数的过程，时间复杂度为 O(1)
 * @author wushijia
 *
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianHolder {
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());//大根堆
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());//小根堆
	
	public void modifyHeap(){//保证两个堆的size之差不超过1
		if(maxHeap.size() == minHeap.size()+2){//大根堆大了
			minHeap.add(maxHeap.poll());
		}
		if(minHeap.size() == maxHeap.size()+2){//小根堆大了
			maxHeap.add(minHeap.poll());
		}
	}
	public void addNumber(int num){
		if(this.maxHeap.isEmpty()){
			this.maxHeap.add(num);
		}
		if(this.maxHeap.peek() >= num){
			this.maxHeap.add(num);
		}else{//如果比大根堆的第一个值小，添加到小根堆
			if(this.minHeap.isEmpty()){
				this.minHeap.add(num);
				return;
			}
			if(this.minHeap.peek() > num){//比小根堆堆顶小
				//添加到大根对
				this.maxHeap.add(num);
			}else{
				this.minHeap.add(num);
			}
		}
		modifyHeap();
	}
	public Integer getMid(){
		int maxsize = this.maxHeap.size();
		int minsize = this.minHeap.size();
		if(maxsize + minsize == 0){
			return null;
		}
		Integer maxhead = this.maxHeap.peek();
		Integer minhead = this.minHeap.peek();
		if((maxsize + minsize)%2 == 0){//偶数个个数
			return (maxhead+minhead)/2;
		}
		return maxsize > minsize ? maxhead : minhead;
	}
}

class MaxHeapComparator implements Comparator<Integer>{//大根堆用的比较器

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 < o2){
			return 1;//返回1表示后面的放前面或者上面;
		}else{//-1表示前面的放前面或者上面
			return -1;
		}
	}
	
}
class MinHeapComparator implements Comparator<Integer>{//小根堆用的比较器

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2){
			return 1;
		}else{
			return -1;
		}
	}
	
}