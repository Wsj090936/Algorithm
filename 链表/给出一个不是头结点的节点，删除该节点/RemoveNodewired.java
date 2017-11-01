package algorithms2;
/**
 * 给出链表中的一个节点node，要求删除链表中的该节点，但是不给出该链表的头结点
 * 思路：
 * 		给出了节点，要求删除该节点，但是没有给出头结点，由于是单链表，所以不能找到该节点的前一个节点，
 * 因此，可以将当前节点的值变为下一个节点，然后将下一个节点删除，这样就做到了删除给定的节点，但是这样
 * 不能删除最后一个节点，因为最后一个节点没有下一个节点，所以需要我们显示的抛出一个异常
 * @author wushijia
 *
 */
public class RemoveNodewired {
	public void remove(Node node){
		if(node == null){
			return;
		}
		Node next = node.next;
		if(next == null){
			throw new RuntimeException("Can not remove the last Node");
		}
		node.value = next.value;
		node.next = next.next;
	}
}
