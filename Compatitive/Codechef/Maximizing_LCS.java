import java.io.*;
import java.util.*;


public class Maximizing_LCS
{
    public static int lcs(String s1, String s2) 
    {
        int n=s1.length();
        int m=s2.length();
        
        int[][] dp=new int[n+1][m+1];
        
        //no need to implement the base cases as all the cells are by default zero.
        
        for(int ind1=1;ind1<=n;++ind1)
        {
            for(int ind2=1;ind2<=m;++ind2)
            {
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                {
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }
                else
                {
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void solve() throws Exception
    {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        
        int T=fr.nextInt();
        while(T-->0)
        {
            int N=fr.nextInt();
            String S=fr.nextLine();

            StringBuilder sb=new StringBuilder(S);
            int ans=lcs(sb.toString(),sb.reverse().toString());
            

            out.println(ans/2);
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