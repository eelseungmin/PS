import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    /*
    단순히 A,B를 그대로 비교하면 O(NM)으로 시간초과

    O(NlogN)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<int[]> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list.add(new int[]{Integer.parseInt(st.nextToken()), 0});
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list.add(new int[]{Integer.parseInt(st.nextToken()), 1});
            }

            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int ans = 0; // 해당 테스트케이스 정답
            int cnt = 0; // 현재까지 나온 b 갯수
            for (int j = 0; j < n + m; j++) {
                if (list.get(j)[1] == 0) { // a에 속한 수
                    ans += cnt;
                } else { // b에 속한 수
                    cnt++;
                }
            }
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}