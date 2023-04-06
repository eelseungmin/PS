import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Integer[] a = new Integer[A.length];
        Integer[] b = new Integer[B.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = A[i];
            b[i] = B[i];
        }
        
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i] * b[i];
        }
        
        return ans;
    }
}