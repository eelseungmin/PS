import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Ballon {
    int num;
    int move;

    public Ballon(int num, int move) {
        this.num = num;
        this.move = move;
    }
}

public class Main {
    /*
    deque 이용
    first 3 2 1 -3 -1 last
    2 1 -3 -1 3
    -1 3 2 1 -3
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Ballon> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            dq.add(new Ballon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        Ballon pre = dq.pollFirst(); // 터진 풍선
        sb.append(pre.num).append(" ");

        while (!dq.isEmpty()) {
            if (pre.move > 0) { // 양수
                for (int i = 0; i < pre.move - 1; i++) { // -1을 해주는 이유는 pre에서 poll을 하는 것도 오른쪽으로 한 번 이동하는 것과 같은 효과이므로
                    dq.offerLast(dq.pollFirst());
                }
            } else { // 음수
                for (int i = 0; i < Math.abs(pre.move); i++) { // 왼쪽으로 이동하는 경우엔 -1을 해주면 안 된다.
                    dq.offerFirst(dq.pollLast());
                }
            }
            pre = dq.pollFirst();
            sb.append(pre.num).append(" ");
        }

        System.out.println(sb);
    }

}