class Solution {
    public String solution(int n) {
        String[] arr = {"4", "1", "2"};
        
        String ans = "";
        while (n > 0) {
            int tmp = n % 3;
            n /= 3;
            
            if (tmp == 0) {
                n--; // 나머지가 0이면 종료
            }
            
            ans = arr[tmp] + ans;
        }
        
        return ans;
    }
}