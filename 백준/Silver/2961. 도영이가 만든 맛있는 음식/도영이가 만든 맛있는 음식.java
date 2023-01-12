import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ingredient {
    long sour;
    long bitter;

    public ingredient(long sour, long bitter) {
        this.sour = sour;
        this.bitter = bitter;
    }
}

public class Main {
    /*

     */
    static ingredient[] ingredients = new ingredient[10];
    static boolean[] vis = new boolean[10];
    static int n;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sour = Integer.parseInt(st.nextToken());
            long bitter = Integer.parseInt(st.nextToken());
            ingredients[i] = new ingredient(sour, bitter);
        }

        func(0, 0, 1, 0); // 신맛은 곱해야 하니까 1로 시작

        System.out.println(min);
    }

    static void func(int select, int cnt, long sour, long bitter) {
        if (cnt == n) {
            if (select != 0) {
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }

        func(select + 1, cnt + 1, sour * ingredients[cnt].sour, bitter + ingredients[cnt].bitter);
        func(select, cnt + 1, sour, bitter);
    }
}