/*
The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
Do it in-place.
*/

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n=matrix.length;

        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(matrix[i][j]==-1) matrix[i][j]=(int)Math.pow(10,9);

                if(i==j) matrix[i][j]=0;
            }
        }

        for(int via=0;via<n;++via)
        {
            for(int i=0;i<n;++i)
            {
                for(int j=0;j<n;++j)
                {
                    matrix[i][j]=Math.min(matrix[i][j], matrix[i][via]+matrix[via][j]);
                }
            }
        }

        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(matrix[i][j]==(int)Math.pow(10,9)) matrix[i][j]=-1;

                if(i==j) matrix[i][j]=0;
            }
        }
    }
}