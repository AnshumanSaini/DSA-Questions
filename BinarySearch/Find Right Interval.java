/*
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
*/

/*
Intuition:

The intuition is to search through all intervals to find the current end index >= start index of some other interval.
We start searching from the interval which has the smallest end index and try to find the minimum start index that is greater than or equal to the current end. Once we find that we do for the next smallest end index and so on.
Since we want to do it for every small end index we can use a minHeap to store the end indices. Again for each min end index we want to find the min start, so we'll use another minHeap for start indices.

Algorithm:

Maintain a minHeapEnd of end indices and a minHeapStart of start indices.
We can iterate through each end index in minHeapEnd and try to find the corresponding start index in the minHeapStart which is greater than equal to the current end element.
Once found we update corresponding index (idx of the current end element) in the final result[] with the start index that we found.
If minHeapStart is empty, then definitely rest all elements in the minHeapEnd can be mapped to -1 in the final result[].
*/

/*
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        PriorityQueue<int[]> minheapStart = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minheapEnd = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
		// Build the 2 minHeaps
        for(int i=0; i < intervals.length; i++){
            minheapStart.add(new int[]{intervals[i][0], i});
            minheapEnd.add(new int[]{intervals[i][1], i});
        }
        
		// Define the final result[]
        int[] result = new int[intervals.length];
        
		// Initialize the result[] with -1
        for(int i=0; i < intervals.length; i++)
            result[i] = -1;
        
        while(!minheapEnd.isEmpty()){
		    // Fetch the smallest end index
            int[] currEnd = minheapEnd.poll();
            int currEndVal = currEnd[0];
            int currEndIdx = currEnd[1];
            
            // Find the first start idx which is greater than or equal to the current end
            while(!minheapStart.isEmpty() && currEndVal > minheapStart.peek()[0])
                minheapStart.poll();
            
            // Since there are no more elements left in minheapStart, that means rest all indices in result[] will be 
            // mapped to -1
            if(minheapStart.isEmpty())
                return result;
            
            // When minheapStart is not empty, then the top most element of minheapStart must be >= currEndVal
            // So we place the corresponding index of the top most element of minheapStart in the corresponding 
            // currEndIdx of the result[]
            result[currEndIdx] = minheapStart.peek()[1];
        }
        return result;
    }
}
*/