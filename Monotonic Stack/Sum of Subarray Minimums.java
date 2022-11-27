import java.util.*;

class Solution 
{
    public int sumSubarrayMins(int[] arr) 
    {
        int n=arr.length;
        Stack<Integer> stk1=new Stack<>();
        Stack<Integer> stk2=new Stack<>();
        int[] prev_smaller=new int[n];
        int[] next_smaller=new int[n];

        for(int i=0;i<n;++i)
        {
            next_smaller[i]=n-i-1;
            prev_smaller[i]=i;
        }

        for(int i=0;i<n;++i)
        {
            while(!stk1.isEmpty() && arr[stk1.peek()]>arr[i])
            {
                next_smaller[stk1.peek()]=i-stk1.peek()-1;
                stk1.pop();
            }
            stk1.push(i);
        }
        stk1.clear();
        for(int i=n-1;i>=0;--i)
        {
            while(!stk1.isEmpty() && arr[stk1.peek()]>arr[i])
            {
                prev_smaller[stk1.peek()]=stk1.peek()-i-1;
                stk1.pop();
            }
            stk1.push(i);
        }
        long sum=0;
        for(int i=0;i<n;++i)
        {
            int val=next_smaller[i]+prev_smaller[i]+1;
            val=(val*(val+1))/2;
            sum+=(val*arr[i]);
        }

        return (int)(sum%1000000007);
    }
}