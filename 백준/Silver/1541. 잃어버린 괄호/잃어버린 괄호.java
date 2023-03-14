import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    - 기준으로 문자열을 분리한 뒤 분리된 문자열에 포함된 + 연산을 모두 수행
    분리된 연산들의 값을 가지고 차례대로 - 연산을 수행한다.

    55-50+40
    55 - 50+40
    55 - 90
    -35
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(input, "-");
        while (st.hasMoreTokens()) {
            String cur = st.nextToken();

            StringTokenizer st2 = new StringTokenizer(cur, "+");
            int sum = 0;
            while (st2.hasMoreTokens()) {
                sum += Integer.parseInt(st2.nextToken());
            }

            q.offer(sum);
        }

        int res = q.poll();; // 정답
        while (!q.isEmpty()) {
            res -= q.poll();
        }

        System.out.println(res);
    }
}