import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    O(N*MlogM)
     */
    static int n, m, v;
    static ArrayList<Integer>[] list; // 간선
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int rear = Integer.parseInt(st.nextToken());
            list[front].add(rear);
            list[rear].add(front);
        }

        /**
         * 정점 번호가 작은 것을 먼저 방문하기 위해 정렬
         * 인접 리스트 대신 인접 행렬을 사용하면 정렬이 필요 없다.
         */
        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        dfs();
        bfs();

        System.out.println(sb);
    }

    public static void dfs() {
        boolean[] vis = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (vis[cur]) {
                continue;
            }

            sb.append(cur + " ");
            vis[cur] = true;

            for (int i = list[cur].size() - 1; i >= 0; i--) { // 번호가 작은 정점이 먼저 탐색되도록 하기 위해서 뒤집어서 push
                stack.push(list[cur].get(i));
            }
        }

        sb.append("\n");
    }

    public static void bfs() {
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (vis[cur]) {
                continue;
            }

            sb.append(cur + " ");
            vis[cur] = true;

            for (int i = 0; i < list[cur].size(); i++) {
                q.offer(list[cur].get(i));
            }
        }

        sb.append("\n");
    }
}