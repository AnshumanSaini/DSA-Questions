/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
*/

/*
Intution: 
			we have to traverse through the array, and find the sum+=(gas[i]-cost[i]) at every index untill the sum become less than zero...

			now all the entries before the jth value where the sum become less than zero will not be the answer... why?

			because all the entries prior to jth index gives positive sum, that means each pair of gas[i]-cost[i] gives positive value...

			and the jth index sum gives negative sum, so if you ignore any previous value that means remove any positive value from the negative value the answer will be negative((-)-(+)==>(-)) so all the values prior to jth index will not be answer... 
*/
class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int ans=0;
        int sumG=0;
        int sumC=0;
        for(int i=0;i<cost.length;++i)
        {
            sumG+=gas[i];
            sumC+=cost[i];
        }
        if(sumG<sumC) return -1;
        
        int sum=0;
        for(int i=0;i<cost.length;++i)
        {
            
            if(sum<0)
            {
                ans=i;
                sum=0;
            }
            sum+=(gas[i]-cost[i]);
        }
        
        return ans;
    }
}