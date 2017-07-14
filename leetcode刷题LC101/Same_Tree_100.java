package algorithms;

public class Same_Tree_100 {
	
    public boolean isSameTree(TreeNode p,TreeNode q){
    	if(p == null && q == null){
    		return true;
    	}
    	if(p == null || q == null){//两个节点中只要有一处不相同就返回false
    		return false;
    	}
    	if(p.val == q.val){
    		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    	}else{
    		return false;
    	}
    }
}
