import java.util.*;

class Solution {
    static int max;
    static int[][] dun;
    static int[] permu;
    static boolean[] vis;
    static int ans;
    
    public int solution(int k, int[][] dungeons) {
        /**
        순열을 이용해서 던전 탐색을 진행하며 최댓값 갱신
        **/
        max = dungeons.length;
        dun = dungeons;
        permu = new int[dungeons.length];
        vis = new boolean[dungeons.length];
        
        choose(0, k);
        
        return ans;
    }
    
    public void choose(int idx, int k) {
        if (idx == max) {
            simulation(k);
            return;
        } 
        
        for (int i = 0; i < permu.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                permu[idx] = i;
                choose(idx + 1, k);
                vis[i] = false;
            }
        }
    }
    
    public void simulation(int k) {
        int num = 0;
        
        for (int i = 0; i < permu.length; i++) {
            if (k < dun[permu[i]][0]) {
                return;
            }
            
            k -= dun[permu[i]][1];
            ans = Math.max(ans, ++num);
        }
    }
}