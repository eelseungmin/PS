import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int j = 0; j < 3; j++) {
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++)
                if (Integer.parseInt(st.nextToken()) == 0) {
                    cnt++;
                }

            switch (cnt) {
                case 0:
                    System.out.println("E");
                    break;
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                case 4:
                    System.out.println("D");
                    break;
            }
        }
    }
}
