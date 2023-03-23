class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] picture;
    static boolean[][] vis;
    static int m, n;
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int size;
    
    public int[] solution(int m, int n, int[][] picture) {
        this.picture = picture;
        vis = new boolean[m][n];
        this.m = m;
        this.n = n;
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        size = 0;
            
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && picture[i][j] != 0) {
                    dfs(i, j, picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                    size = 0;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public static void dfs(int x, int y, int number) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        
        if (vis[x][y] || picture[x][y] != number) {
            return;
        }
        
        vis[x][y] = true;
        size++;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            dfs(nx, ny, number);
        }
    }
}