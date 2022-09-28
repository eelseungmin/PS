import java.io.*;
import java.util.*;

public class Main {
    /*
    2번과 3번 연산이 최소가 되도록
    1번 deque pollFirst
    2번 deque pollFirst offerLast
    3번 deque pollLast offerFirst

    1. 숫자를 확인한다.
    2. 숫자의 위치를 확인해서 왼쪽에 쏠려있으면 2번, 오른쪽이면 3번 연산 수행
    3. 2번, 3번 연산을 할 때마다 cnt 증가
    4. cnt 출력
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        int cnt = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }

        for (int i = 0; i < k; i++) {
            int find = Integer.parseInt(st2.nextToken());
            int findIndex = dq.indexOf(find);
            int halfIndex = 0;

            if (dq.size() % 2 == 0) { // deque 중간 지점 찾기
                halfIndex = dq.size() / 2 - 1;
            } else {
                halfIndex = dq.size() / 2;
            }

            if (findIndex <= halfIndex) { // 중간보다 왼쪽에 위치
                for (int j = 0; j < findIndex; j++) {
                    dq.offerLast(dq.pollFirst());
                    cnt++;
                }
            } else { // 중간보다 오른쪽
                for (int j = 0; j < dq.size() - findIndex; j++) {
                    dq.offerFirst(dq.pollLast());
                    cnt++;
                }
            }

            dq.pollFirst();
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
