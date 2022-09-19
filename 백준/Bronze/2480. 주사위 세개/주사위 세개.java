import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[7];
        int big = -1;

        for (int i = 1; i <= 3; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 3) {
                System.out.println(10000 + i * 1000);
                return;
            } else if (arr[i] == 2) {
                System.out.println(1000 + i * 100);
                return;
            } else if (arr[i] == 1) {
                big = i;
            }
        }

        System.out.println(big * 100);
    }
}
