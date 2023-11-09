import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*

     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        StringTokenizer st = new StringTokenizer(tmp);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int cnt = 0;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> ma : map.entrySet()) {
            if (ma.getValue() >= 2) {
                cnt++;
                list.add(ma.getKey());
            }
        }

        Collections.sort(list);
        sb.append(cnt).append('\n');
        for (String l : list) {
            sb.append(l).append('\n');
        }

        System.out.println(sb);
    }
}