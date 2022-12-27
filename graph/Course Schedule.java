/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/
/*
INTUTION:

in [a,b] the couse a is dependent on course b so,  we can say if there is a cyclic dependency then we are not able to finish all the courses,
so, we only have to check for the cyclic graph.
*/

import java.util.*;

class Solution 
{
    public boolean canFinish(int numCourses, int[][] pre) 
    {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int[] indegree=new int[numCourses];

        for(int[] a : pre)
        {
            ++indegree[a[1]];
            if(map.containsKey(a[0]))
            {
                map.get(a[0]).add(a[1]);
            }
            else
            {
                List<Integer> list=new ArrayList<>();
                list.add(a[1]);
                map.put(a[0],list);
            }
        }
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;++i)
        {
            if(indegree[i]==0) q.add(i);
        }
        int cnt=0;
        while(!q.isEmpty())
        {
            Integer hld=q.poll();
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

        if(cnt==numCourses) return true;
        else return false;
    }
}
