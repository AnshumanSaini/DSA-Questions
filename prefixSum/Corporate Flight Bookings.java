/*
There are n flights that are labeled from 1 to n.

You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.

Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.
*/

/*
Intution: 
			we have to add the numbers in the columns range specified in the 0th and the 1st index of the row....

			so we will just add the number to the last index of that range and add the negative of the number at the one less index of the lower range.....

			because we will assume to add the number from the position to left most index of the resulting array.....

			and the negative number will nullify the affect of adding the number to the indexes out of the range.....
*/

class Solution 
{
    public int[] corpFlightBookings(int[][] bookings, int n) 
    {
        int[] diff=new int[n];
        for(int[] row : bookings)
        {
            diff[row[1]-1]+=row[2];
            if(row[0]-2>=0) diff[row[0]-2]-=(row[2]);
        }
        int[] ans=new int[n];
        ans[n-1]=diff[n-1];
        for(int i=n-2;i>=0;--i)
        {
            ans[i]=diff[i]+ans[i+1];
        }
        
        return ans;
    }
}