/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
*/

/*
Intution:
			we have to start from the other row and columns.....
*/

class Solution 
{
    public void solve(int[][] heights,int r, int c, boolean[][] ocean,int prevHeight)
    {
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length || prevHeight>heights[r][c])
            return;
        if(ocean[r][c]==true) return;
        ocean[r][c]=true;
        
        solve(heights,r-1,c,ocean,heights[r][c]);
        solve(heights,r+1,c,ocean,heights[r][c]);
        solve(heights,r,c-1,ocean,heights[r][c]);
        solve(heights,r,c+1,ocean,heights[r][c]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        int n=heights.length;
        int m=heights[0].length;
        //System.out.println(n+" "+m+" ........................");
        List<List<Integer>> ans=new ArrayList<>();
        
        boolean[][] atl=new boolean[n][m];
        boolean[][] pac=new boolean[n][m];
        
        for(int r=0;r<n;++r)
        {
            solve(heights,r,0,pac,Integer.MIN_VALUE);
            solve(heights,r,m-1,atl,Integer.MIN_VALUE);
        }
        
        for(int c=0;c<m;++c)
        {
            solve(heights,0,c,pac,Integer.MIN_VALUE);
            solve(heights,n-1,c,atl,Integer.MIN_VALUE);
        }
        
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                if(atl[i][j] && pac[i][j])
                {
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    ans.add(tmp);
                }
            }
        }
        
        return ans;
    }
}