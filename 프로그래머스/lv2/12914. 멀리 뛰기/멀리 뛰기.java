class Solution {
    /*
    n=1
    1
    
    n=2
    11
    2
    
    n=3
    12
    21
    111
    
    n=4
    1111
    112
    121
    211
    22
    
    n=5
    11111
    1112
    1121
    1211
    2111
    122
    212
    221
    */
    public long solution(int n) {
        long[] dp = new long[n + 1];
        
        if (n == 1) {
            return 1;
        }
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % 1234567  + dp[i - 2] % 1234567;
        }
        
        return dp[n] % 1234567;
    }
}