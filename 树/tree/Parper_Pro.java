package tree;
/**
 * 折纸问题
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，
 * 压出折痕后展开。此时 折痕是凹下去的，即折痕突起的方向指向纸条的背面。
 * 如果从纸条的下边向上方连续对折2 次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、
 * 下折痕和上折痕。给定一 个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向
 * @author wushijia
 *其实考察的是二叉树的中序遍历
 */
public class Parper_Pro {
	public static void printDownUp(int n){
		if(n < 1){
			return;
		}
		printParper(1,n,true);//true表示向下，凹下去的
	}
	private static void printParper(int i,int n,boolean down){
		if(i > n){
			return;
		}
		printParper(i + 1,n,true);
		System.out.println(down ? "down" : "up");
		printParper(i + 1,n,false);
	}
}
