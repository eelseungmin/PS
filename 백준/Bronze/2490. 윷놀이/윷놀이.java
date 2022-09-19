import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        int cnt = 0;
        char res = ' ';

        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(st.nextToken()) == 0) {
                cnt++;
            }
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
        cnt = 0;

        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(st2.nextToken()) == 0) {
                cnt++;
            }
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
        cnt = 0;

        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(st3.nextToken()) == 0) {
                cnt++;
            }
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
        bw.flush();
    }
}
