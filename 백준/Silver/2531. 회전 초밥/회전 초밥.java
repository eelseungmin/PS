import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    /*
    투 포인터를 움직인다.
    같은 위치에서 시작
    k보다 작게 고른 동안 r과 고른 횟수를 증가시킨다.
    d를 갱신
    l을 움직인다.
    l이 한 바퀴를 다 돌았으면 탐색을 종료한다.

    k개를 달성했을 때 고른 초밥 중에 쿠폰에 적힌 초밥이 없다면 가짓수를 +1
    있다면 가짓수에 변화가 없다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> map = new HashMap<>(); // 초밥 종류, 고른 횟수
        int l = 0;
        int r = 0;
        int cnt = 1; // 현재 먹은 초밥의 가짓수
        int eat = 1; // 현재 연속으로 먹은 초밥 갯수
        map.put(sushi[0], 1);
        int ans = Integer.MIN_VALUE; // 정답
        while (l < n) {
            if (!map.containsKey(c)) {
                ans = Math.max(ans, cnt + 1);
            } else {
                ans = Math.max(ans, cnt);
            }

            if (eat < k) {
                r++;
                r %= n; // 원형으로 연결되어 있으므로 r이 n-1을 넘어갈 때 원점으로 되돌려야 한다.

                map.put(sushi[r], map.getOrDefault(sushi[r], 0) + 1);
                cnt = map.size();
                eat++;
                continue;
            }

            map.put(sushi[l], map.get(sushi[l]) - 1);
            if (map.get(sushi[l]) == 0) {
                map.remove(sushi[l]);
            }
            cnt = map.size();
            eat--;

            l++;
        }

        System.out.println(ans);
    }
}