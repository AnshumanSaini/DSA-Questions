import java.util.*;

class DataStream 
{
    PriorityQueue<Integer> pq=;
    int val;
    int max;
    int toRemove=-1;
    List<Integer> q;
    public DataStream(int value, int k) 
    {
        q=new ArrayList<Integer>();
        pq=new PriorityQueue<Integer>();
        this.val=value;
        this.max=k;
    }
    
    public boolean consec(int num) 
    {
        q.add(num);
        pq.add(num);

        if(q.size()>k)
        {
            toRemove=q.get(0);
            q.remove(0);
            pq.remove(toRemove);
        }
        if(pq.size()<max) return false;
        if(pq.peek()!=pq.toArray()[0]) return false;
        else return true;
        
    }
}

