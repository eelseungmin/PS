import java.io.*;
import java.util.*;

public class Main {
    /*
    2초, 256MB

    1. 전부 큐에 넣는다.
    2. k-1까지 큐에서 빼서 다시 넣는다.
    3. 큐가 완전히 빌 때까지 반복한다.
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(i + 1);
        }

        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                int tmp = q.poll();
                q.offer(tmp);
            }

            if (q.size() > 1) {
                sb.append(q.poll() + ", ");
            } else {
                sb.append(q.poll() + ">");
            }
        }

        System.out.println(sb);
    }
}
