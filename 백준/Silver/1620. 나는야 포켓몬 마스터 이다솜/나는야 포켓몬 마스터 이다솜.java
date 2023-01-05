import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            arr.add(br.readLine());
            map.put(arr.get(i - 1), i);
        }
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if (Character.isDigit(tmp.charAt(0))) {
                sb.append(arr.get(Integer.parseInt(tmp) - 1)).append('\n');
            } else {
                sb.append(map.get(tmp)).append('\n');
            }
        }

        System.out.println(sb);
    }
}