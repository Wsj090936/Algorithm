package algorithms;
/**
 *  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

	Example 1:
	
	11110
	11010
	11000
	00000
	Answer: 1
	
	Example 2:
	
	11000
	11000
	00100
	00011
	Answer: 3
 * @author wushijia
 *
 */
public class Number_of_Islands_200 {
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        if(m == 0){
            return 0;
        }
        n = grid[0].length;
        for(int i = 0; i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == '1'){
                    DFS(grid,i,j);
                    ++res;
                }
            }
        }
        return res;
    }
    private void DFS(char[][] grid,int i,int j){
        if(i < 0 || j < 0 || i >=m || j >= n || grid[i][j] != '1'){return;}
        grid[i][j] = '0';//遍历过的地方标记
        DFS(grid,i + 1,j);//下
        DFS(grid,i - 1,j);//上
        DFS(grid,i,j + 1);//右
        DFS(grid,i,j - 1);//左
    }
}
