import java.io.*;
import java.util.*;

public class Main {
    /*

     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();

            switch (temp) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.poll() + "\n");
                    }
                    break;

                case "size":
                    sb.append(q.size() + "\n");
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.getFirst() + "\n");
                    }
                    break;

                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.getLast() + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}