import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations); // 0 1 3 5 6
        
        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i]) {
                answer = n - i;
                break;
            }
        }
        
        return answer;
    }
}