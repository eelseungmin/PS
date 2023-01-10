import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    /*
    O(NlgN)
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hash = new HashMap<>(); // <문자열, 카운트>
        int total = 0;
        while (true) {
            String tmp = br.readLine();

            if (tmp == null) { // 입력이 더 이상 없으면 입력 종료
                break;
            }

            hash.put(tmp, hash.getOrDefault(tmp, 0) + 1);
            total++;
        }

        Object[] dict = hash.keySet().toArray();
        Arrays.sort(dict); // O(NlgN), N = 10000

        StringBuilder sb = new StringBuilder();
        for (Object d : dict) {
            double percent = (double) (hash.get((String) d) * 100) / total;

            sb.append(d + " " + String.format("%.4f", percent) + "\n");
        }

        System.out.println(sb);
    }
}