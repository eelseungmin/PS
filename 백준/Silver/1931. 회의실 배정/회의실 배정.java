import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    /*
    정렬 + 그리디
    O(NlogN)
    */
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 회의가 빨리 끝나는 순으로 정렬, 끝나는 시간이 같으면 시작하는 시간이 빠른 순으로 정렬
        @Override
        public int compareTo(Meeting m) {
            if (this.end == m.end) {
                return start - m.start;
            }
            return end - m.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        Collections.sort(list);

        int cnt = 1; // 정답
        Meeting cur = list.get(0); // 막 끝난 회의
        for (int i = 1; i < list.size(); i++) {
            Meeting next = list.get(i);
            if (cur.end <= next.start) {
                cnt++;
                cur = next;
            }
        }

        System.out.println(cnt);
    }
}