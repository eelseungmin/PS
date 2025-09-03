import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] vis;
    
    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n];
        vis = new boolean[n];
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) graph[i].add(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(n, i);
                ans++;
            }
        }
        
        return ans;
    }
    
    public void dfs(int n, int v) {
        for (int i = 0; i < graph[v].size(); i++) {
            int cur = graph[v].get(i);
            
            if (!vis[cur]) {
                vis[cur] = true;
                dfs(n, cur);
            }
        }
    }
}