import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Doc {
    int rank; // 중요도
    boolean wanted; // 필요 여부

    public Doc(int rank, boolean wanted) {
        this.rank = rank;
        this.wanted = wanted;
    }
}

public class Main {
    /*

     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            LinkedList<Doc> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken()); // 필요한 문서의 idx
            int ans = 0; // 필요한 문서의 인쇄 순서
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int rank = Integer.parseInt(st.nextToken());
                if (j == idx) { // 필요한 문서일 때
                    q.offer(new Doc(rank, true));
                } else {
                    q.offer(new Doc(rank, false));
                }
            }

            while (!q.isEmpty()) {
                Doc curDoc = q.poll();
                ans++;
                boolean flag = false; // 큐에 curDoc을 다시 넣었는지 여부

                for (Doc d : q) { // 큐 돌면서 중요도 체크
                    if (curDoc.rank < d.rank) {
                        q.offer(curDoc);
                        ans--; // 인쇄하지 않았으므로 인쇄 횟수 감소
                        flag = true;
                        break;
                    }
                }

                if (curDoc.wanted && !flag) { // 인쇄할 문서가 필요한 문서라면
                    sb.append(ans).append('\n');
                    break;
                }
            }
        }

        System.out.println(sb);
    }

}