import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    /*

     */
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if (!maxHeap.isEmpty()) {
                    sb.append(maxHeap.remove());
                } else {
                    sb.append(0);
                }
                sb.append('\n');
            } else {
                maxHeap.add(tmp);
            }
        }

        System.out.println(sb);
    }
}