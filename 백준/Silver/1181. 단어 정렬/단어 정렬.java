import java.io.*;
import java.util.*;

public class Main {
    /*

     */
    static int n;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res;

                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i].equals(arr[i - 1])) {
                continue;
            }
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
}