import java.io.*;
import java.util.*;

public class Main {
    /*
    a,b,c가 21억(int 최대)
    0.5초 -> O(a,b,c) x

     */

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(calc(a, b, c));
    }

    public static long calc(long a, long b, long c) {
        // a^b mod c -> a^b/2 mod c * a^b/2 mod c
        // a^7 mod c -> a^3 mod c * a^3 mod c * a mod c
        if (b == 1) {
            return a % c; // a가 c보다 클 수도 있으니까
        }

        long val = calc(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 0) { // b가 짝수
            return val;
        }
        return val * a % c; // b가 홀수(2 3 7의 경우처럼)
    }
}