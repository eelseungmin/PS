import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dist;
    static int[][] map;
    
    public int solution(int[][] maps) {
        map = maps;
        dist = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        bfs();
        
        return dist[map.length - 1][map[0].length - 1];
    }
    
    class Node {
        int x, y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        dist[0][0] = 1;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }
                
                if (dist[nx][ny] >= 0 || map[nx][ny] != 1) {
                    continue;
                }
                
                q.offer(new Node(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }
    }
}