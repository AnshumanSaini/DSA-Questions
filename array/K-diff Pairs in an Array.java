/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
nums[i] - nums[j] == k
Notice that |val| denotes the absolute value of val.
*/

/*
Intution: 
			we do not have to consider here the repeated elements as we require the distinct pairs....

			we have to put all the elements in the hashMap along with their frequencies....

			then we have to traverse the map if...

			the value of k==0 then we can have the same pair for repeating value, so just increase the ans by 1...

			if the value of k>=1, then we have to find the i+k key in the map...

			and if that key has frequency >=1 then increase the pointer by 1;
*/
class Solution 
{
    public int findPairs(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        if(nums.length==1) return 0;
        for(int i : nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //System.out.println(set);
        int ans=0;
        
        for(int i : map.keySet()) 
        {
            if(k==0)
            {
                if(map.get(i)>1) ++ans;
            }
            else
            {
                if(map.containsKey(i+k))
                {
                    if(map.get(i+k)>=1) ++ans;
                }
            }
        }
        
        return ans;
    }
}