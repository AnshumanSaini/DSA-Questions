/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
*/

class Solution 
{
    public void DFS(char[][] board,int i, int j, boolean[][] vis)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='X') return;
        
        if(vis[i][j]==true) return;
        
        vis[i][j]=true;
        DFS(board,i+1,j,vis);
        DFS(board,i-1,j,vis);
        DFS(board,i,j+1,vis);
        DFS(board,i,j-1,vis);
        
    }
    public void solve(char[][] board) 
    {
        int row=board.length;
        int col=board[0].length;
        boolean[][] vis=new boolean[row][col];
        
        for(int i=0;i<col;++i)
        {
            if(board[0][i]=='O') DFS(board,0,i,vis);
        }
        for(int i=0;i<col;++i)
        {
            if(board[row-1][i]=='O') DFS(board,row-1,i,vis);
        }
        for(int i=0;i<row;++i)
        {
            if(board[i][0]=='O') DFS(board,i,0,vis);
        }
        for(int i=0;i<row;++i)
        {
            if(board[i][col-1]=='O') DFS(board,i,col-1,vis);
        }
        
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(board[i][j]=='O' && vis[i][j]==false) board[i][j]='X';
            }
        }
    }
}