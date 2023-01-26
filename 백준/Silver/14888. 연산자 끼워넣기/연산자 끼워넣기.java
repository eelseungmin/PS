import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    조건 고려하면 int 사용

    중복 없이 순서 있게 나열
     */
    static int n;
    static int[] arr;
    static int[] operator;
    static int[] permutation;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        operator = new int[4];
        permutation = new int[n - 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        makePermu(0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void makePermu(int cnt, int value) {
        if (cnt == n - 1) { // 만든 연산자 순서대로 계산
            max = Math.max(max, value);
            min = Math.min(min, value);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) {
                continue;
            }
            operator[i]--;
            permutation[cnt] = i;
            int newValue = calc(i, value, cnt);
            makePermu(cnt + 1, newValue);
            permutation[cnt] = -1;
            operator[i]++;
        }
    }

    private static int calc(int operator, int value, int cnt) {
        int newValue = value;

        switch (operator) {
            case 0: // '+'
                newValue += arr[cnt + 1];
                break;
            case 1:
                newValue -= arr[cnt + 1];
                break;
            case 2:
                newValue *= arr[cnt + 1];
                break;
            case 3:
                newValue /= arr[cnt + 1];
                break;
        }

        return newValue;
    }
}