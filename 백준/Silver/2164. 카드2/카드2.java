import java.io.*;
import java.util.*;

public class Main {
    /*
    rear N ... 3 2 1 front
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int cnt = 1;
        while (q.size() != 1) {
            if (cnt % 2 == 1) {
                q.poll();
            } else {
                int temp = q.poll();
                q.offer(temp);
            }
            cnt++;
        }

        bw.write(q.poll() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
