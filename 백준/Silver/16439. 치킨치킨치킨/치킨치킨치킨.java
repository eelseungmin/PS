import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    O(NM^3)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] gori = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                gori[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0; // 모든 경우를 고려했을 때의 최대 만족도
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < m; l++) {
                    // 한 사람이 같은 치킨을 선택할 수 없으므로
                    if (j == k || k == l || l == j) {
                        continue;
                    }

                    int satis = 0; // 한 사람의 최대 만족도
                    int sum = 0; // 모든 사람의 최대 만족도
                    for (int i = 0; i < n; i++) {
                        satis = Math.max(gori[i][j], gori[i][k]);
                        satis = Math.max(satis, gori[i][l]);
                        sum += satis;

                        satis = 0;
                    }

                    ans = Math.max(ans, sum); // 갱신
                }
            }
        }

        System.out.println(ans);
    }
}