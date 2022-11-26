import java.util.*;

class Solution 
{
    public int maximumGain(String s, int x, int y) 
    {
        char[] chk=new char[]{'b','a'};
        char[] sarr=s.toCharArray();
        if(x>y)
        {
            chk[0]='a';
            chk[1]='b';
        }
        int sum=0;
        Stack<Integer> stk=new Stack<>();
        int val=Math.max(x,y);
        for(int i=0;i<s.length();++i)
        {
            if(sarr[i]!=chk[1])
            {
                stk.push(i);
            }
            else 
            {
                if(sarr[i]==chk[1] && !stk.isEmpty() && sarr[stk.peek()]==chk[0])
                {
                    sarr[stk.peek()]='.';
                    sarr[i]='.';
                    stk.pop();
                    sum+=val;
                }
            }
        }
        stk.clear();
        //for(int i=0;i<s.length();++i) System.out.print(sarr[i]);
        //System.out.println();
        //System.out.println(chk[0]+" "+chk[1]);
        char tmp=chk[1];
        chk[1]=chk[0];
        chk[0]=tmp;
        val=Math.min(x,y);
        //System.out.println(chk[0]+" "+chk[1]);
        for(int i=0;i<s.length();++i)
        {
            if(sarr[i]=='.') continue;
            if(sarr[i]!=chk[1])
            {
                stk.push(i);
            }
            else 
            {
                if(sarr[i]==chk[1] && !stk.isEmpty() && sarr[stk.peek()]==chk[0])
                {
                    //System.out.println("sadddddddddd");
                    sarr[stk.peek()]='.';
                    sarr[i]='.';
                    stk.pop();
                    sum+=val;
                }
            }
        }

        return sum;
    }
}