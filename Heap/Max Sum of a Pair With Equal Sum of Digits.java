/*
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
*/

import java.util.*;

class Solution 
{
    public int getDigitSum(int num)
    {
        int sum=0;
        while(num!=0)
        {
            sum+=(num%10);
            num/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) 
    {
        int[][] arr=new int[nums.length][2];
        
        for(int i=0;i<nums.length;++i)
        {
            arr[i][0]=nums[i];
            arr[i][1]=getDigitSum(nums[i]);
        }

        Arrays.sort(arr,(a,b) -> b[1]-a[1]);

        for(int i=0;i<nums.length;++i)
        {
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }

        int curr=arr[0][1];
        List<Integer> list=new ArrayList<>();
        int max=-1;
        for(int i=0;i<nums.length;++i)
        {
            if(arr[i][1]==curr)
            {
                list.add(arr[i][0]);
                if(i==nums.length-1)
                {
                    if(list.size()>=2)
                    {
                        Collections.sort(list,Collections.reverseOrder());
                        max=Math.max(max,(list.get(0)+list.get(1)));
                    }
                }
            }
            else
            {
                if(list.size()>=2)
                {
                    Collections.sort(list,Collections.reverseOrder());
                    max=Math.max(max,(list.get(0)+list.get(1)));
                }
                //System.out.println(list+"......");
                curr=arr[i][1];
                list.clear();
                list.add(arr[i][0]);
            }
        }
        return max;
    }
}