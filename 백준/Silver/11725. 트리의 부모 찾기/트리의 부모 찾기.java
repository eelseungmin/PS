import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /*
          1
         / \
        6   4
       /   / \
      3   7   2
     /
    5

    노드 갯수 n개, n-1개의 간선이 주어지므로 인접행렬, 인접리스트 둘 다 상관없다.
    인접리스트를 만들어두고 dfs를 루트노트를 시작점으로 설정하여 수행
    parent 배열에 부모 노드 표시

    O(N)
     */
    static int n;
    static ArrayList<ArrayList<Integer>> conn;
    static int[] parent;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        conn = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            conn.add(new ArrayList<>());
        }

        parent = new int[n + 1];
        vis = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            conn.get(from).add(to);
            conn.get(to).add(from);
        }

        dfs(0, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int ex, int cur) {
        if (vis[cur]) {
            return;
        }

        parent[cur] = ex;
        vis[cur] = true;

        for (int i = 0; i < conn.get(cur).size(); i++) {
            dfs(cur, conn.get(cur).get(i));
        }
    }
}