import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int tmp = k;
        sb.append("<");
        while (!q.isEmpty()) {
            tmp--;
            if (tmp == 0) {
                sb.append(q.poll());
                if (q.isEmpty()) {
                    sb.append(">");
                    break;
                } else {
                    sb.append(", ");
                }
                tmp = k;
            } else {
                q.offer(q.poll());
            }
        }

        System.out.println(sb);
    }
}