import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    O(NlogN)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] ingredients = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredients);

        int p1 = 0;
        int p2 = n - 1;
        int cnt = 0;
        while (p1 < p2) {
            int sum = ingredients[p1] + ingredients[p2];

            if (sum < m) {
                p1++;
            } else if (sum > m) {
                p2--;
            } else {
                p1++;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}