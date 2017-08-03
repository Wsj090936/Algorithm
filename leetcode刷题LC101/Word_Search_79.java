package algorithms;
/**
 *  Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
	
	For example,
	Given board =
	
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
 * @author wushijia
 *
 */
public class Word_Search_79 {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];//初始值都为false
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                if((word.charAt(0) == board[i][j]) && search(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][] board,String word,int i,int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i >= board.length || j >= board[i].length || j < 0 || word.charAt(index) != board[i][j] || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(search(board,word,i - 1,j,index + 1) ||
           search(board,word,i + 1,j,index + 1) ||
           search(board,word,i,j - 1,index + 1) ||
           search(board,word,i,j + 1,index + 1) ){
            return true;
        }
        visited[i][j] = false;//如果没有找到符合的就将访问点设置为false
        return false;
    }
}
