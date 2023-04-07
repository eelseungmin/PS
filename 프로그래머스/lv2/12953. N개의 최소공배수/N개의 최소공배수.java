class Solution {
    public int solution(int[] arr) {
        int ans = lcm(arr[0], arr[1]);
        
        if (arr.length > 2) {
            for (int i = 2; i < arr.length; i++) {
                ans = lcm(ans, arr[i]);
            }
        }
        
        return ans;
    }
    
    // gcd(a, b) = gcd(b, r)
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
    
    // a*b = gcd(a,b) * lcm(a,b)
    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}