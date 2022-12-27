/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Input: numCourses = 1, prerequisites = []
Output: [0]
*/

/*
INTUTION:

in [a,b] the couse a is dependent on course b so,  we can say if there is a cyclic dependency then we are not able to finish all the courses,
so, we only have to check for the cyclic graph.
*/

import java.util.*;

class Solution 
{
    public int[] findOrder(int numCourses, int[][] pre) 
    {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int[] indegree=new int[numCourses];

        for(int[] a : pre)
        {
            ++indegree[a[0]];
            if(map.containsKey(a[1]))
            {
                map.get(a[1]).add(a[0]);
            }
            else
            {
                List<Integer> list=new ArrayList<>();
                list.add(a[0]);
                map.put(a[1],list);
            }
        }
        Queue<Integer> q=new LinkedList<>();

        int[] ans=new int[numCourses];
        int k=0;
        int cnt=0;
        for(int i=0;i<numCourses;++i)
        {
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty())
        {
            Integer hld=q.poll();
            ans[k++]=hld;
            ++cnt;
            if(!map.containsKey(hld)) 
            {
                continue;
            }
            for(Integer i : map.get(hld))
            {
                --indegree[i];
                if(indegree[i]==0) q.add(i);
            }
        }

        if(cnt!=numCourses) return new int[0];
        return ans;
    }    
}