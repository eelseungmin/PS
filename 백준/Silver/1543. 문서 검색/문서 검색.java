import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = br.readLine();

        int i = 0;
        int len = target.length();
        int cnt = 0;
        // 9 - 3
        // ababab 5 6 7 8
        while (i < str.length() - target.length() + 1) {
            if (str.substring(i, i + len).equals(target)) {
                cnt++;
                i = i + len;
            } else {
                i++;
            }
        }

        System.out.println(cnt);
    }
}