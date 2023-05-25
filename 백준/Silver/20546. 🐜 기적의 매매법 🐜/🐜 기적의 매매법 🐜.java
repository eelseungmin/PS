import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int money;
    static int[] price;
    static int bnp;
    static int timing;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        price = new int[14];
        for (int i = 0; i < 14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        doBNP();
        doTIMING();

        if (bnp > timing) {
            System.out.println("BNP");
        } else if (bnp < timing) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    static void doBNP() {
        int total = money;
        int cnt = 0;
        for (int i = 0; i < 14; i++) {
            cnt += total / price[i];
            total -= total / price[i] * price[i];
        }

        bnp = price[13] * cnt + total;
    }

    static void doTIMING() {
        int total = money;
        int cnt = 0;
        int yesterday = price[0];
        int asc = 0;
        int desc = 0;
        for (int i = 0; i < 14; i++) {
            if (i != 0 && yesterday < price[i]) {
                desc = 0;
                asc++;
                if (asc == 3) {
                    cnt = 0;
                    total += cnt * price[i];
                }
            }
            if (i != 0 && yesterday > price[i]) {
                asc = 0;
                desc++;
                if (desc == 3) {
                    cnt += total / price[i];
                    total -= total / price[i] * price[i];
                }
            }
        }

        timing = price[13] * cnt + total;
    }
}