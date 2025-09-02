import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int ans = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        /**
        간선을 차례대로 하나씩 빼고 전력망을 구성한 후 
        bfs나 dfs로 송전탑 개수를 구한 뒤 최소 절대값 갱신
        O(n^2)
        **/
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            graph[wires[i][1]].remove(Integer.valueOf(wires[i][0]));
            
            int abs = Math.abs(bfs(n, wires[i][0]) - bfs(n, wires[i][1]));
            ans = Math.min(ans, abs);
            
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        return ans;
    }
    
    public int bfs(int n, int v) {
        int tower = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];
        
        tower++;
        vis[v] = true;
        q.offer(v);
    
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                
                if (!vis[next]) {
                    tower++;
                    vis[next] = true;
                    q.offer(next);
                }
            }
        }
        
        return tower;
    }
}