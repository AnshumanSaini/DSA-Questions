/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
*/

import java.util.*;
class Solution 
{
    public void rememberStack(Stack<Character> stk1, Stack<Character> stk)
    {
        stk1.clear();
        stk1.addAll(stk);
    }
    public boolean solve(Stack<Character> stk, int ind, char[] ch)
    {
        if(ind==ch.length) 
        {
            /*for(int i=0;i<ch.length;++i) System.out.print(ch[i]+" ");
            System.out.println(stk);
            */
            if(stk.isEmpty()) return true;
            else return false;
        }

        if(ch[ind]=='*')
        {
            //empty String
            //System.out.println(stk);
            Stack<Character> stk1=new Stack<>();
            rememberStack(stk1,stk);
            
            boolean empty=solve(stk,ind+1,ch);
            rememberStack(stk,stk1);
            //System.out.println(stk+"............");
            
            //right paranthesis
            ch[ind]=')';
            boolean right=solve(stk,ind,ch);
            ch[ind]='*';
            rememberStack(stk,stk1);
            //System.out.println(stk);
            //left paranthesis
            ch[ind]='(';
            boolean left=solve(stk,ind,ch);
            ch[ind]='*';
            rememberStack(stk,stk1);
            //System.out.println(left);
            //System.out.println(empty+"....."+right+"....."+left);
            return (empty || right || left);
        }
        else
        {
            if(ch[ind]=='(') 
            {
                stk.push(')');
                return solve(stk,ind+1,ch);
            }
            else
            {
                /*System.out.print("popping: ");
                for(int i=0;i<ch.length;++i) System.out.print(ch[i]+" ");
                System.out.println(stk);
                */
                if(stk.isEmpty()) return false;
                stk.pop();
                return solve(stk,ind+1,ch);
            }
        }
    }
    public boolean checkValidString(String s) 
    {
        Stack<Character> stk=new Stack<>();
        char[] charr=s.toCharArray();
        return solve(stk,0,charr);
    }
}