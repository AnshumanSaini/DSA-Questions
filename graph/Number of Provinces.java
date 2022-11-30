/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
*/
class Solution 
{
    public void travelDFS(int i,boolean[] vis,int[][] arr)
    {
        if(vis[i]==true) return;
        
        vis[i]=true;
        for(int j=0;j<arr[i].length;++j)
        {
            if(arr[i][j]==1) travelDFS(j,vis,arr);
        }
    }
    public int findCircleNum(int[][] arr) 
    {
        boolean[] vis=new boolean[arr.length];
        int row=arr.length;
        int col=arr[0].length;
        int ans=0;
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(arr[i][j]==1 && vis[i]==false)
                {
                    ++ans;
                    travelDFS(i,vis,arr);
                }
            }
        }
        return ans;
    }
}
