import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Job> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer(new Job(i, progresses[i]));
        }
        ArrayList<Integer> answer = new ArrayList<>();
        
        int day = 0; // 경과한 날
        while (!q.isEmpty()) {
            day++;
            
            int cnt = 0; // 오늘 배포할 작업의 수
            while (!q.isEmpty() && q.peek().pro + speeds[q.peek().idx] * day >= 100) {
                q.poll();
                cnt++;
            }
            if (cnt != 0) {
                answer.add(cnt);
            }
        }
        
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
    
    class Job {
        int idx;
        int pro;
        
        Job(int idx, int pro) {
            this.idx = idx;
            this.pro = pro;
        }
    }
}