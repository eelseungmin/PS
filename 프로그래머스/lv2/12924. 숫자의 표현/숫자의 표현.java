class Solution {
    /*
    
    */
    public int solution(int n) {
        int ans = 0; // 정답
        int sum = 0;
        int r = 0;
        for (int l = 1; l <= n; l++) {
            while (r < n && sum < n) {
                r++;
                sum += r;
            }
            
            if (sum == n) {
                ans++;
            }
            
            sum -= l;
        }
        
        return ans;
    }
}