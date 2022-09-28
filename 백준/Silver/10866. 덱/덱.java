import java.io.*;
import java.util.*;

public class Main {
    /*

     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollFirst() + "\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollLast() + "\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekLast() + "\n");
                    }
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
