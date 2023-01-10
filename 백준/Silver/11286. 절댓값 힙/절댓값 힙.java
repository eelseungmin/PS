import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    /*
    O(NlgN)
     */
    // write your code here
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(0).append('\n');
                    continue;
                }
                int peek = minHeap.peek();
                if (hash.get(-peek) == null) {
                    hash.put(peek, hash.get(peek) - 1);
                    if (hash.get(peek) <= 0) {
                        hash.remove(peek);
                    }
                    sb.append(minHeap.remove()).append('\n');
                } else {
                    hash.put(-peek, hash.get(-peek) - 1);
                    if (hash.get(-peek) <= 0) {
                        hash.remove(-peek);
                    }
                    sb.append(-minHeap.remove()).append('\n');
                }
            } else {
                minHeap.offer(Math.abs(tmp));
                hash.put(tmp, hash.getOrDefault(tmp, 0) + 1);
            }
        }

        System.out.println(sb);
    }
}