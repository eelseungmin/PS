import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*

     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, ".");
            st.nextToken();
            String str = st.nextToken();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            list.add(str);
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String l : list) {
            sb.append(l + " " + map.get(l)).append('\n');
        }

        System.out.println(sb);
    }
}