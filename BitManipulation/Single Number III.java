/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
*/

/*
	we have to divide the whole number into 2 groups and each group contains exactly one single character.

	for this we need to find the right most set bit of the zor of all the values in the array..

	To find the right most set bit in the number a is "a&(~(a-1))"....
*/

class Solution 
{
    public int[] singleNumber(int[] nums) 
    {
        int sum=0;
        for(int i : nums) sum^=i;
        
        int chk=sum&(~(sum-1));
        //System.out.println(chk);
        int[] ans=new int[2];
        for(int i : nums)
        {
            if((chk&i)==0) ans[0]^=i;
            else ans[1]^=i;
        }
        
        return ans;
    }
}