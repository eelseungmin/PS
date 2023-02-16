import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    
     */
    static long a, b;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        res = -1;

        recursion(a, 0);

        System.out.println(res);
    }

    static void recursion(long x, int cnt) {
        if (x >= b) {
            if (x == b) {
                res = cnt + 1;
            }
            return;
        }

        recursion(x * 2, cnt + 1);
        recursion(x * 10 + 1, cnt + 1);
    }
}