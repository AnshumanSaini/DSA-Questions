/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/

import java.util.*;

class Solution 
{
    public void setZeroes(int[][] matrix)
    {
        Set<Integer> rowSet=new HashSet<>();;
        Set<Integer> colSet=new HashSet<>();

        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[0].length;++j)
            {
                if(matrix[i][j]==0)
                {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }

            for(int i=0;i<matrix.length;++i)
            {
                for(int j=0;j<matrix[0].length;++j)
                {
                    if(rowSet.contains(i) || colSet.contains(j)) matrix[i][j]=0;
                }
            }
        }
    }  
}