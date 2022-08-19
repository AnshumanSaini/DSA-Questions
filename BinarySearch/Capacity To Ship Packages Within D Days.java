/******************Binary search is used when we have a range of value and we have to find the a value within that range*************/
/*
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
*/

/*
Intution:
			the left value has to be the maximum value in the array(because that value will cover all the weights atleast),and the right value has to be the sum of all the values of the array(as the maximmum weight can not exceed the sum)...

			now find the mid value and check weather it is possible to ship all the containers within the given days...

*/

class Solution 
{
    public int shipWithinDays(int[] arr, int days) 
    {
        int l=0;
        int r=0;
        for(int i : arr)
        {
            r+=i;
            l=Math.max(l,i);
        }
        int ans=r;
        while(l<=r)
        {
            int mid=(r-l)/2 +l ;
            
            if(correct(arr,mid,days)==true)
            {
                ans=Math.min(ans,mid);
                r=mid-1;
            }
            else l=mid+1;
        }
        
        return ans;
    }
    
    public boolean correct(int[] arr,int val,int d)
    {
        int cnt=0;
        int sum=0;
        for(int i=0;i<arr.length;++i)
        {
            sum+=arr[i];
            if(sum>val)
            {
                sum=arr[i];
                ++cnt;
                
            }
            //System.out.println(sum);
        }
        ++cnt;
        if(cnt>d) return false;
        else return true;
    }
}