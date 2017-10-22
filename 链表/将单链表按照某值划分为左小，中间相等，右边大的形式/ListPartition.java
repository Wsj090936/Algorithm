package algorithms;
/**
 * 这是普通方法，先遍历链表，得到链表的长度，然后根据此长度创建一个数组，然后将链表中的每一个节点放入数组，然后根据所给的数privot
 * 将数组中的每一个节点与他进行比较，比他小的放左边，大的放右边
 * @author wushijia
 *
 */
public class ListPartition {
	public Node part1(Node head,int pivot){//其中pivot指的是中间节点，左边的节点都小于他，右边的节点都大于它
		if(head == null){
			return null;
		}
		Node cur = head;
		int i = 0;
		while(cur != null){
			i++;
			cur = cur.next;
		}
		Node[] arr = new Node[i];
		i = 0;
		cur = head;
		for(i = 0;i < arr.length;i++){//将链表中的每一个节点入数组
			arr[i] = cur;
			cur = cur.next;
		}
		partition(arr, pivot);
		for(i = 1;i < arr.length;i++){//开始组合链表
			arr[i - 1].next = arr[i];
		}
		arr[i - 1].next = null;//最后一个节点的next指向空
		return arr[0];//数组的元素作为链表的第一个节点
		
	}
	private void partition(Node[] arr,int pivot){//开始按照题目要求生成数组，但是不管顺序
		int small = -1;
		int big = arr.length;
		int index = 0;
		while(index != arr.length){
			if(arr[index].value < pivot){
				swap(arr,++small,index++);
			}else if(arr[index].value == pivot){
				index++;
			}else{
				swap(arr,--big,index);
			}
		}
	}
	private void swap(Node[] arr,int a,int b){//交换数组中的元素
		Node tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
