import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    주가가 떨어지는 시점에 매도를 하는 방식으로 풀 수 있지 않을까 했지만 잘못된 접근이었다.
    현재 주식을 현재 이후에 가장 주가가 높은 날에 팔아야 최대 이익을 도출할 수 있다.
    즉, 가장 비싸게 팔 수 있는 날까지 등락에 관계 없이 주식을 매수하고 매도한 이후에도
    가장 비싸게 팔 수 있는 날을 다시 고려하는 식으로 끝까지 계산한다.

    그런데 위의 로직을 앞에서부터 확인하는 방식으로 구현하려면 for문을 이중으로 사용해야 해서 O(N^2)의 시간복잡도를 보인다.
    따라서 뒤에서부터 확인하는 방식으로 구현하면 O(N)으로 구현이 가능하다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] price = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0; // 정답
            int max = price[n - 1]; // 최대 주가
            for (int i = n - 2; i >= 0; i--) {
                if (price[i] > max) {
                    max = price[i]; // 아무것도 하지 않는다.
                } else {
                    ans += max - price[i]; // 주식을 매도한다.
                }
            }

            System.out.println(ans);
        }
    }
}