import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    /*

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isDigit(i)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static boolean isDigit(int num) {
        if (1 <= num && num < 100) {
            return true;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (num != 0) { // 각 자릿수 구해서 list에 추가
            list.add(num % 10);
            num /= 10;
        }

        int diff = 10000;
        int falseF = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (diff != 10000) {
                if (diff != list.get(i) - list.get(i + 1)) {
                    falseF++;
                }
            }
            diff = list.get(i) - list.get(i + 1);
        }

        if (falseF > 0) {
            return false;
        } else {
            return true;
        }
    }
}