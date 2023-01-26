import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    중복 없이 순서와 무관하게 k개 중 6개를 고르기
     */
    static int[] arr;
    static int[] seq;
    static boolean[] isUsed;
    static StringBuilder sb;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) { // 0이면 입력 종료
                break;
            }

            arr = new int[k];
            seq = new int[6];
            isUsed = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            makeComb(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void makeComb(int cnt, int start) {
        if (cnt == 6) {
            for (int i : seq) {
                sb.append(i + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < k; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (cnt != 0 && seq[cnt - 1] > arr[i]) {
                continue;
            }
            isUsed[i] = true;
            seq[cnt] = arr[i];
            makeComb(cnt + 1, start + 1);
            isUsed[i] = false;
        }
    }
}