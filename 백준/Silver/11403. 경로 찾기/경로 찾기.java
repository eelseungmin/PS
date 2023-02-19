import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    O(N^3)
     */
    static int n;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] dist;
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        dist = new int[n];
        res = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        Arrays.fill(dist, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, i);
            Arrays.fill(dist, -1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int cur) { // 시작 노드, 현재 노드
        if (dist[cur] != -1) {
            return;
        }

        dist[cur]++;

        for (int next : adj.get(cur)) {
            res[start][next] = 1; // 시작 노드 -> 다음 노드
            res[cur][next] = 1; // 현재 노드 -> 다음 노드
            dfs(start, next);
        }
    }
}