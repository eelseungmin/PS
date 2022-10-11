import java.io.*;
import java.util.*;

public class Main {
    /*
    2초, 128MB
    수빈이가 이동 중에 0에서 100000 사이에서만 움직여야 한다는 조건은 없으므로 그것도 고려해야 한다.
    밖으로 나가는 것도 가능
     */

    static int[] dist = new int[100002];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(dist, -1);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 수빈이 위치 큐에 입력
        dist[n] = 0;
        q.offer(n);
        bfs(k);

        System.out.println(dist[k]);
    }

    public static void bfs(int k) {
        while (dist[k] == -1) { // 동생 위치에 시간이 입력되기 전까지 탐색 수행
            int cur = q.poll();

            for (int nx : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (nx < 0 || nx > 100000) {
                    continue;
                }
                
                if (dist[nx] != -1) {
                    continue;
                }

                dist[nx] = dist[cur] + 1;
                q.offer(nx);
            }
        }
    }
}
