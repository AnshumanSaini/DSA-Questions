/*
A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).

You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:

Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
*/

/*
Intution:
			There are two cases when we have to make T to F, and other is to make F to T.....

			we have to maintain a queue where we have to insert the location where we encounter F when we have to change F by T....

			if the size of queue is increased by k then make j=poll()+1;....

			and keep on updating the answer......	
*/

class Solution 
{
    public int maxConsecutiveAnswers(String s, int k) 
    {
        Queue<Integer> q=new LinkedList<>();
        int i=0;
        int j=0;
        int cnt=0;
        int ans=0;
        for(;i<s.length();++i)
        {
            if(s.charAt(i)=='F')
            {
                q.add(i);
                ++cnt;
            }
            if(cnt>k)
            {
                --cnt;
                j=q.poll()+1;
            }
            ans=Math.max(ans,(i-j+1));
        }
        cnt=0;
        j=0;
        i=0;
        q.clear();
        for(;i<s.length();++i)
        {
            if(s.charAt(i)=='T')
            {
                q.add(i);
                ++cnt;
            }
            if(cnt>k)
            {
                --cnt;
                j=q.poll()+1;
            }
            ans=Math.max(ans,(i-j+1));
        }
        return ans;
    }
}