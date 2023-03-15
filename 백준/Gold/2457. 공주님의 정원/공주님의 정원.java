import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    /*
    매번 현재 시점에서 피어있는 꽃 중에서 가장 마지막에 지는 꽃을 선택
    m * 100 + d
    날짜를 위와 같이 표현하는 게 효율적

    close가 1201 이상인 꽃이 마지막 꽃(문제 조건 참조)
     */
    static class Flower {
        int open, close;

        Flower(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Flower> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int om = Integer.parseInt(st.nextToken());
            int od = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());
            int cd = Integer.parseInt(st.nextToken());
            list.add(new Flower(om * 100 + od, cm * 100 + cd));
        }

        int cur = 301; // 현재 시간
        int ans = 0; // 정답
        while (cur < 1201) {
            int next = cur; // 추가된 꽃의 지는 시간

            for (int i = 0; i < n; i++) {
                Flower f = list.get(i);
                if (f.open <= cur && f.close > next) {
                    next = f.close; // 꽃 추가
                }
            }

            if (next == cur) { // 꽃 추가가 되지 않은 경우 0 출력
                System.out.println(0);
                return;
            }

            ans++;
            cur = next;
        }

        System.out.println(ans);
    }
}