package algorithms;
/**
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	Given target = 5, return true.
	
	Given target = 20, return false.
	
	题目大意：给出一个二维数组，数组中的数字大小从左到右一次递增，从上到下依次递减，现在给出一个数，
	用很短的时间判断该数是否存在于这个数组中
	思路: 从数组的右上角或者左下角开始寻找，就会使得时间大大减少
 * @author wushijia
 *
 */
public class Search_a_2D_Matrix_II_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0){
    		return false;
    	}
    	int i = 0;//从右上角开始
    	int j = matrix[0].length - 1;//列
    	while(i < matrix.length && j >= 0){
    		if(target > matrix[i][j]){
    			++i;
    		}else if(target < matrix[i][j]){
    			--j;
    		}else return true;
    	}
    	return false;
    }
}
