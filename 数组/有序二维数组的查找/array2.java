package algorithms;
/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
import org.junit.Test;

public class array2 {
    public boolean Find(int target, int [][] array) {
		int line = array.length;
        int list = array[0].length;
        int i = line - 1;
        int j = 0;
        for(;i>=0&&j<list;)
            {
            	if(target == array[i][j])
                    return true;
            	else if(target>array[i][j])
                    { 
                    	j = j+1;
                }else if(target<array[i][j])
                    {
                    	i = i-1;
                }
        }
		return false;
    }
}
