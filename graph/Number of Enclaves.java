/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
*/
class Solution 
{
    public void DFS(int[][] board, int i, int j, boolean[][] vis)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]==0) return;
        
        if(vis[i][j]==true) return;
        
        vis[i][j]=true;
        DFS(board,i+1,j,vis);
        DFS(board,i-1,j,vis);
        DFS(board,i,j-1,vis);
        DFS(board,i,j+1,vis);
    }
    public int numEnclaves(int[][] board) 
    {
        int row=board.length;
        int col=board[0].length;
        boolean[][] vis=new boolean[row][col];
        
        for(int i=0;i<col;++i)
        {
            if(board[0][i]==1) DFS(board,0,i,vis);
        }
        for(int i=0;i<col;++i)
        {
            if(board[row-1][i]==1) DFS(board,row-1,i,vis);
        }
        for(int i=0;i<row;++i)
        {
            if(board[i][0]==1) DFS(board,i,0,vis);
        }
        for(int i=0;i<row;++i)
        {
            if(board[i][col-1]==1) DFS(board,i,col-1,vis);
        }
        int ans=0;
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(vis[i][j]==false && board[i][j]==1) ++ans;
            }
        }
        
        return ans;
    }
}