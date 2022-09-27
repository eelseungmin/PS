import java.io.*;
import java.util.*;

public class Main {
    /*

     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int back = -1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    back = Integer.parseInt(st.nextToken());
                    q.offer(back);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.poll());
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peek());
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(back);
                    }
                    break;
            }
        }
    }
}