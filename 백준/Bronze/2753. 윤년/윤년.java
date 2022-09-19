import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            bw.write(1+"");
        } else {
            bw.write(0+"");
        }

        bw.flush();
    }
}
