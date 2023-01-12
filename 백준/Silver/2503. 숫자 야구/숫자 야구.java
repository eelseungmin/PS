import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    O(8100N) -> O(N)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] question = new String[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                question[i][j] = st.nextToken();
            }
        }

        int ans = 0; // 정답 갯수
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || k == i) { // 서로 다른 숫자만 가능
                        continue;
                    }
                    String tmp = i + "" + j + "" + k;

                    int cnt = 0; // cnt == n이면 ans 1 증가
                    // 질문 갯수만큼 체크
                    for (int l = 0; l < n; l++) {
                        int strike = 0;
                        int ball = 0;

                        for (int m = 0; m < 3; m++) {
                            for (int o = 0; o < 3; o++) {
                                // 각각의 위치에 있는 문자가 일치
                                if (tmp.charAt(m) == question[l][0].charAt(o)) {
                                    // 위치까지 일치
                                    if (m == o) {
                                        strike++;
                                    } else {
                                        ball++;
                                    }
                                }
                            }
                        }

                        // 해당 질문의 strike, ball 중 하나라도 일치하지 않으면 해당 숫자는 답이 아님
                        if (Integer.parseInt(question[l][1]) != strike || Integer.parseInt(question[l][2]) != ball) {
                            break;
                        } else {
                            cnt++;
                        }
                    }
                    if (cnt == n) { // // cnt == n이면 ans 1 증가
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}