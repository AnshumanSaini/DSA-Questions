/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*/

/*
Intution: 
			First make the transpose of the matrix...

			then make the reverse of every row and the answer is the rotated matrix by 90 degree...
*/
class Solution 
{
    public void rotate(int[][] matrix) 
    {
        int n=matrix.length;
        for(int i=0;i<n;++i)
        {
            for(int j=i;j<n;++j)
            {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        
        for(int i=0;i<n;++i)
        {
            int l=0;
            int r=n-1;
            while(l<r)
            {
                int tmp=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=tmp;
                ++l;
                --r;
            }
        }
    }
}