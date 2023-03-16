import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    /*

     */
    static int n;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        Arrays.fill(dist, -1);

        bfs();

        System.out.println(dist[n]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1]++;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int res : new int[]{cur * 3, cur * 2, cur + 1}) {
                if (res > n) {
                    continue;
                }

                if (dist[res] != -1) {
                    continue;
                }

                dist[res] = dist[cur] + 1;
                q.offer(res);
            }
        }
    }
}