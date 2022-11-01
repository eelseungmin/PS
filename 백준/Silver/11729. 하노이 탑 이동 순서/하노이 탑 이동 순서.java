import java.io.*;
import java.util.*;

public class Main {
    /*
    원판 1...n-1, n
    1부터 n-1까지 2로 옮긴다.
    n을 3으로 옮긴다.
    1부터 n-1까지 3으로 옮긴다.
    -> n-1개일 때 원판을 원하는 곳으로 옮길 수 있으면 n개일 떄도 원판을 원하는 곳으로 옮길 수 있다.

    1개일 때 옮길 수 있다.
    n개일 때 원판을 원하는 곳으로 옮길 수 있으므로 n+1개일 때도 원판을 원하는 곳으로 옮길 수 있다.
     */
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        bw.write((int)Math.pow(2, n) - 1 + "\n");
        move(1, 3, n);

        bw.flush();
        bw.close();
    }

    public static void move(int a, int b, int n) throws Exception {
        if (n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }

        move(a, 6 - a - b, n - 1);
        bw.write(a + " " + b + "\n");
        move(6 - a - b, b, n - 1);
    }
}
