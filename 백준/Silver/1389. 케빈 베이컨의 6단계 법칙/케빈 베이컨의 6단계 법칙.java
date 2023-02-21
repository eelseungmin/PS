import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    O(N*(N+M))
     */
    static int n, m;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        edges = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges.get(from).add(to);
            edges.get(to).add(from);
        }

        calcMin();
    }

    static void calcMin() {
        int value = Integer.MAX_VALUE;
        int person = 0; // 정답

        for (int i = n; i >= 1; i--) { // 여러 명일 경우 번호가 작은 사람을 출력하기 위해 역순으로
            Arrays.fill(dist, -1);
            int cnt = bfs(i); // i의 케빈 베이컨 수

            if (cnt <= value) {
                value = cnt;
                person = i;
            }
        }

        System.out.println(person);
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        dist[start]++;
        q.offer(start);

        int cnt = 0; // 단계
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : edges.get(cur)) {
                if (dist[next] != -1) {
                    continue;
                }

                dist[next] = dist[cur] + 1;
                cnt += dist[next]; // start와 각 친구와의 단계를 더해준다.
                q.offer(next);
            }
        }

        return cnt;
    }
}