package tanxin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 参数4，正数m
costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多做k个项目 m表示你初始的资金
说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个 项目。
输出： 你最后获得的最大钱数
 * @author wushijia
 *
 */
public class I_P_O {
	public static class Node{
		public int c;//表示项目的启动资金
		public int p;//表示完成项目后获得的收益
		public Node(int c,int p){
			this.c = c;
			this.p = p;
		}
	}
	public static class MaxComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.p > o2.p){
				return -1;
			}else if(o1.p < o2.p){
				return 1;
			}
			return 0;
		}
		
	}
	public static class MinComparator implements Comparator<Node>{
		
		@Override
		public int compare(Node o1, Node o2) {
			if(o1.c > o2.c){
				return 1;
			}else if(o1.c < o2.c){
				return -1;
			}
			return 0;
		}
		
	}
	private static int getMaxMoney(int[] costs,int[] profits,int k,int m){
		Node[] nodes = new Node[costs.length];
		for(int i = 0;i < profits.length;i++){
			nodes[i] = new Node(costs[i],profits[i]);
		}
		PriorityQueue<Node> minQ = new PriorityQueue<>(new MinComparator());//小根堆，开始存放着所有项目
		PriorityQueue<Node> maxQ = new PriorityQueue<>(new MaxComparator());//大根堆，存放能够做的项目
		for(int i = 0;i < nodes.length;i++){
			minQ.add(nodes[i]);
		}
		int res = m;
		for(int i = 0;i < k;i++){
			while(!minQ.isEmpty() && minQ.peek().c < res){//将启动资金小于m的放入大根堆
				maxQ.add(minQ.poll());
			}
			if(maxQ.isEmpty()){//当大根对没有node时，可以返回
				return res;
			}
			res = res + maxQ.poll().p;//每次做完一个项目就加上利润
		}
		return res;
	}
	public static void main(String[] args) {
		
	}
	
}
