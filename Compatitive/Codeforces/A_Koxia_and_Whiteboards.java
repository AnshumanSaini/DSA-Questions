import java.io.*;
import java.util.*;

public class A_Koxia_and_Whiteboards
{ 
    public static void solve() throws Exception
    {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=fr.nextInt();
        while(T-->0)
        {
            int n=fr.nextInt();
            int m=fr.nextInt();

            PriorityQueue<Integer> pq=new PriorityQueue<>();

            for(int i=0;i<n;++i) pq.add(fr.nextInt());
            PriorityQueue<Integer> pq1;
            
            if(m<=n) pq1=new PriorityQueue<>(Collections.reverseOrder());
            else pq1=new PriorityQueue<>();

            for(int i=0;i<m;++i) pq1.add(fr.nextInt());
            //out.println(pq);
            //out.println("...............");
            //out.println(pq1);
            while(!pq1.isEmpty())
            {
                pq.poll();
                pq.add(pq1.poll());
            }
            long sum=0;
            while(!pq.isEmpty()) sum+=pq.poll();

            out.println(sum);
        }
        out.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while(st==null || !st.hasMoreElements())
            {
                try
                {
                    st=new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        Double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str="";
            try
            {
                str=br.readLine();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static int find_max(int[] arr)
    {
        int max=0;
        int i=0;
        while(i<arr.length)
        {
            if(arr[i]>arr[max]) max=i;
            ++i;
        }
        return max;
    }

    static long gcd(long a, long b)
    {
    if (b == 0)
        return a;
    return gcd(b, a % b);
    }
    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    static int countBits(int n)
    {
        int count = 0;
        while (n != 0)
        {
            count++;
            n >>= 1;
        }
         
        return count;
    }
    public static String reverseStr(String str)
    {
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
    public static long getSum(long N)
    {
        long res=0;
        while(N!=0)
        {
            res+=N%10;
            N/=10;
        }
        return res;
    }
    public static int __(int x, int y) {return x;}
    public static void reverseArray(int []arr)
    {
        int n=arr.length;
        for (int i = 0; i < n / 2; i++)
            arr[i] = __(arr[n - i - 1],
                        arr[n - i - 1] = arr[i]);
    }
    public static void main(String args[])
    {
        try
        {
            solve();
        }
        catch(Exception e)
        {
            return;
        }
    }
}