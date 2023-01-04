import java.util.*;

class Solution
{
    static long findGoodPairs(int a[], int n, int k)
    {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;++i)
        {
            if(map.containsKey(a[i]))
            {
                map.get(a[i]).add(i);
            }
            else
            {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(a[i],list);
            }
        }
        long cnt=0;
        for(Map.Entry<Integer,List<Integer>> val : map.entrySet())
        {
            List<Integer> hld=val.getValue();
            for(int i=0;i<hld.size();++i)
            {
                for(int j=i+1;j<hld.size();++j)
                {
                    if(hld.get(i)-hdl.get(j)>=k)
                    {
                        cnt+=(hld.size()-1-j)+1;
                        break;
                    }
                }
            }
        }

        return cnt;
    }
 
}