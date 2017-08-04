package algorithms;
/**
 *  Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	
	Note: You can only move either down or right at any point in time.
 * @author wushijia
 *由于只能往下走或者往右走，因此到达右下角只能从右下角单元格的上方或者左方到达，然后取这两条路径中值较小的一个即可
 */
public class Minimum_Path_Sum_64 {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] arr = new int[rows][cols];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(i == 0 && j == 0){
                    arr[i][j] = grid[i][j];
                }else if(i == 0){
                    arr[i][j] = arr[i][j -1] + grid[i][j];//第一行
                }else if(j == 0){
                    arr[i][j] = arr[i - 1][j] + grid[i][j];//第一列
                }else{
                    arr[i][j] = Math.min(arr[i - 1][j],arr[i][j - 1]) + grid[i][j];//选择最小的
                }
            }
        }
        return arr[rows - 1][cols - 1];
    }
}
