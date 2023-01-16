import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    매 상담마다 할지 안할지 선택
    N일을 넘는지 확인
     */
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] cost;
    static int[] profit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n + 1];
        profit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }

        func(1, 0);

        System.out.println(max);
    }

    static void func(int day, int sum) {
        if (day == n + 1) {
            max = Math.max(max, sum);
            return;
        }

        if (day > n) {
            return;
        }

        func(day + cost[day], sum + profit[day]);
        func(day + 1, sum);
    }
}