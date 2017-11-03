package algorithms2;
/**
 * 打印二叉树的边界节点
 * 				1
 * 			  /    \
 * 			 /      \
 * 			/        \
 * 		   /     	  3
 * 		  /           /\
 * 	     2			 5  6	   
 * 	      \   		/\  
 * 	       4 	   9  10
 * 	      / \     /
 * 	     7   8    12
 * 	    	  \    /\
 * 	     	   11 15 16
 * 	     	  /  \
 * 	     	 13   14
 * 如，以上的树应该打印 1 2 4 7 11 13 14 15 16 12 10 6 3 
 * @author wushijia
 *
 */
public class PrintEdge {
	public void fun1(Node2 root){
		if(root == null){
			return;
		}
		int h = getHeight(root,0);
		Node2[][] edgeMap = new Node2[h][2];//存放左半部分的边界节点和右半部分的边界节点
		initEdgeMap(root,0,edgeMap);
		for(int i = 0;i != edgeMap.length;i++){//打印所有左边界
			System.out.println(edgeMap[i][0].value);
		}
		//打印既不是左边界，又不是有边界的叶子结点
		printNoneLR(root,0,edgeMap);
		//打印右边界，但不是左边界
		for(int i = edgeMap.length - 1;i != -1;i--){
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.println(edgeMap[i][1].value);
			}
		}
		
	}
	private int getHeight(Node2 root,int i){//得到二叉树的高度
		if(root == null){
			return 1;
		}
		return Math.max(getHeight(root.left,i + 1), getHeight(root.right,i + 1));
	}
	private void initEdgeMap(Node2 root,int h,Node2[][] edgeMap){//初始化数组，将[x][0]存放左半部分边界节点，[x][1]存放右半部分节点
		if(root == null){
			return;
		}
		edgeMap[h][0] = edgeMap[h][0] == null ? root : edgeMap[h][0];//存放左边界节点
		edgeMap[h][1] = root;//存放右边界节点
		initEdgeMap(root.left,h + 1,edgeMap);
		initEdgeMap(root.right,h + 1,edgeMap);
	}
	private void printNoneLR(Node2 root,int i,Node2[][] edgeMap){//打印既不是左边界又不是有边界的节点
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null && root != edgeMap[i][0] && root != edgeMap[i][1]){
			System.out.println(root.value);
		}
		printNoneLR(root.left,i + 1,edgeMap);
		printNoneLR(root.right,i + 1,edgeMap);
	}
}
