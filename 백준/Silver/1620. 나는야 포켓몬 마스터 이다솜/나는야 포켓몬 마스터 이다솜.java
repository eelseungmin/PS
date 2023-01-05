import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[100001];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            arr[i] = br.readLine();
            map.put(arr[i], i);
        }
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if (Character.isDigit(tmp.charAt(0))) {
                sb.append(arr[Integer.parseInt(tmp)]).append('\n');
            } else {
                sb.append(map.get(tmp)).append('\n');
            }
        }

        System.out.println(sb);
    }
}