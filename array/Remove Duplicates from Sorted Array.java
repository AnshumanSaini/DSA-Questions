/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
*/

/*Intution:
				As the array is sorted so all the same elements are collected together...
				Use two pointer i from 0 and j from 1..
				if i==j that means both the ements are same so we have to ignore the elemnt i.e. we only increase the j pointer...
				and i pointer is increased only when i!=j...
				because the i will only have all the distinct elements before him...
*/
class Solution 
{
    public int removeDuplicates(int[] arr) 
    {
        int i=0;
        for(int j=1;j<arr.length;++j)
        {
            if(arr[j]!=arr[i])
            {
                ++i;
                arr[i]=arr[j];
            }
        }
        return i+1;
    }
}