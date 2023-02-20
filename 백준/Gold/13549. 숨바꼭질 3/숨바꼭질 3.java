import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    /*
    그래프가 주어지지 않지만 노드와 간선을 문제를 통해 만들어낸다.
    각각의 숫자들이 노드 역할
    이동 방법이 일종의 간선 역할

    해당 문제는 순간이동의 가중치가 0으로 다른 간선들과 가중치가 다르므로 0-1 BFS를 사용한다.
    0-1 BFS 구현을 위해 deque 사용
     */
    static int n, k;
    static int[] dist = new int[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, -1);

        bfs();
        System.out.println(dist[k]);
    }

    static void bfs() {
        Deque<Integer> dq = new ArrayDeque<>();
        dist[n]++;
        dq.offerLast(n);

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            int next = cur * 2; // 순간이동, 이동에 0초가 필요하므로 +0
            if (0 <= next && next <= 200000 && dist[next] == -1) {
                dist[next] = dist[cur];
                dq.offerFirst(next);
            }
            next = cur + 1; // X+1로 이동
            if (0 <= next && next <= 200000 && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                dq.offerLast(next);
            }

            next = cur - 1; // X-1로 이동
            if (0 <= next && next <= 200000 && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                dq.offerLast(next);
            }
        }
    }
}