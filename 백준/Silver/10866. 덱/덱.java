import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!dq.isEmpty()) {
                        sb.append(dq.removeFirst());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "pop_back":
                    if (!dq.isEmpty()) {
                        sb.append(dq.removeLast());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(dq.size() + "\n");
                    break;
                case "empty":
                    if (!dq.isEmpty()) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    if (!dq.isEmpty()) {
                        sb.append(dq.getFirst());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (!dq.isEmpty()) {
                        sb.append(dq.getLast());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}