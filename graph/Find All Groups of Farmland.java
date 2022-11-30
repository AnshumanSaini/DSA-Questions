/*
You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are no groups of farmland, return an empty array. You may return the answer in any order.
*/
import java.lang.reflect.Array;
import java.util.*;

class Solution 
{
    public void DFS(int[][] land, int r, int c, int[] arr)
    {
        if(r<0 || r>=land.length || c<0 || c>=land[0].length || land[r][c]!=1) return;
        land[r][c]=0;
        int sum1=(int)(Math.abs(arr[0]-arr[2]) + Math.abs(arr[1]-arr[3]));
        int sum2=(int)(Math.abs(arr[0]-r) + Math.abs(arr[1]-c));
        if(sum2>=sum1) 
        {
            arr[2]=r;
            arr[3]=c;
        }
        DFS(land, r+1, c, arr);
        DFS(land, r-1, c, arr);
        DFS(land, r, c+1, arr);
        DFS(land, r, c-1, arr);

    }
    public int[][] findFarmland(int[][] land) 
    {
        ArrayList<int[]> list=new ArrayList<>();

        for(int i=0;i<land.length;++i)
        {
            for(int j=0;j<land[0].length;++j)
            {
                if(land[i][j]!=1) continue;
                int[] arr=new int[4];
                arr[0]=i;
                arr[1]=j;
                arr[2]=i;
                arr[3]=j;
                DFS(land,i,j,arr);
                list.add(arr);
            }
        }

        int[][] ans=new int[list.size()][4];
        int k=0;
        for(int[] r : list)
        {
            ans[k][0]=r[0];
            ans[k][1]=r[1];
            ans[k][2]=r[2];
            ans[k][3]=r[3];
            ++k;
        }

        return ans;
    }
}