/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
*/

/*
Intution:
			find the neighbour elements count and perform the conditions as given...

			for performing in-place we can simply remove updated 0 with 1 and updated 1 with 3
			or vice a versa...
*/

class Solution 
{
    public int getSum(int[][] board,int i,int j)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return 0;
        if(board[i][j]==2) return 1;
        if(board[i][j]==3) return 0;
        return board[i][j];
    }
    public void gameOfLife(int[][] board) 
    {
        for(int i=0;i<board.length;++i)
        {
            for(int j=0;j<board[0].length;++j)
            {
                
                int sum=getSum(board,i-1,j)+getSum(board,i+1,j)+
                        getSum(board,i,j-1)+getSum(board,i,j+1)+
                        getSum(board,i+1,j+1)+getSum(board,i-1,j-1)+
                        getSum(board,i+1,j-1)+getSum(board,i-1,j+1);
                if(board[i][j]==1)
                {
                    if(sum<2 || sum>3) board[i][j]=2;
                    if(sum==2 || sum==3) board[i][j]=1;
                    
                }
                else
                {
                    if(board[i][j]==0)
                    {
                        if(sum==3) board[i][j]=3;
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;++i)
        {
            for(int j=0;j<board[0].length;++j)
            {
                if(board[i][j]==2) board[i][j]=0;
                if(board[i][j]==3) board[i][j]=1;
            }
        }
    }
}