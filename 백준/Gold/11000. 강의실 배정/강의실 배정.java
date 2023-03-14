import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
    시작 시간을 기준으로 정렬
    O(NlogN)
     */
    static class Class implements Comparable<Class> {
        int start, end;

        Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class c) {
            if (this.start == c.start) {
                return this.end - c.end;
            }
            return this.start - c.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Class> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Class(s, e));
        }

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(list.get(0).end);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start >= pq.peek()) {
                pq.poll(); // 해당 강의실에서 원래 강의 다음에
                pq.offer(list.get(i).end); // 새로운 강의 배정
            } else {
                pq.offer(list.get(i).end); // 새로운 강의실 추가
            }
        }

        System.out.println(pq.size());
    }
}