/*
You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
*/

/*
Intution:
			we have to sort the array on the basis of the first value and if the first value is same then we have to compare on the basis of the second value....

			now we have to implement the max Heap...

			and any value that is out of the range of the current value we have to remove it from the heap as that will include in the same group...

			and the answer will be the size of the heap....
*/

class Solution 
{
    public int minGroups(int[][] intervals) 
    {
        Arrays.sort(intervals, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->Integer.compare(a,b));

        for(int[] row : intervals)
        {
            if(!heap.isEmpty() && heap.peek()<row[0]) heap.poll();

            heap.add(row[1]);
        }

        return heap.size();
    }
}