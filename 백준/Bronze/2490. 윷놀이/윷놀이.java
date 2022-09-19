import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cnt = 0;
        char res = ' ';

        for (int j = 0; j < 3; j++) {
            cnt = 0;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++)
                if (Integer.parseInt(st.nextToken()) == 0) {
                    cnt++;
                }

            switch (cnt) {
                case 0:
                    res = 'E';
                    break;

                case 1:
                    res = 'A';
                    break;

                case 2:
                    res = 'B';
                    break;

                case 3:
                    res = 'C';
                    break;

                case 4:
                    res = 'D';
                    break;
            }

            bw.write(res + "\n");
        }

        bw.flush();
    }
}