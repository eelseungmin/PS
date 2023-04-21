import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cntK = 0; // K 이상인 수의 갯수
        for (int s : scoville) {
            if (s >= K) {
                cntK++;
            }
            pq.offer(s);
        }
        
        if (cntK == scoville.length) { // 섞기 전에 이미 모든 음식의 지수가 7 이상
            return 0;
        }
        
        int ans = 0;
        while (pq.size() != 1) { // 더 이상 섞을 수 없을 때까지 섞기
            int one = pq.poll();
            int two = -1;
            if (!pq.isEmpty()) {
                two = pq.poll();
            }
            
            if (two > -1) {
                if (one >= K) {
                    cntK--;
                }
                if (two >= K) {
                    cntK--;
                }
                int res = one + two * 2; // 섞기
                ans++;
                
                if (res >= K) {
                    cntK++;
                }
                
                pq.offer(res);
            }
            
            if (cntK == pq.size()) { // 모든 음식의 지수가 7 이상
                return ans;
            }
        }
        
        return -1;
    }
}