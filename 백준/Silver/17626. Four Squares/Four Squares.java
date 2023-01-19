import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int a = 0; a < 224; a++) {
            int cnt = 0;
            for (int b = a; b < 224; b++) {
                for (int c = b; c < 224; c++) {
                    for (int d = c; d < 224; d++) {
                        if (a * a + b * b + c * c + d * d == n) {
                            if (a != 0) {
                                cnt++;
                            }
                            if (b != 0) {
                                cnt++;
                            }
                            if (c != 0) {
                                cnt++;
                            }
                            if (d != 0) {
                                cnt++;
                            }
                            System.out.println(cnt);
                            return;
                        }
                    }
                }
            }
        }
    }
}