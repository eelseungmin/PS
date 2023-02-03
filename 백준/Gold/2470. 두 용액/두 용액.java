import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    /*
    절댓값 기준으로 정렬을 하면
    예를 들어 2와 -2가 붙어서 정렬이 된다.
    앞에서부터 2개씩 합쳐서 0과 가장 가까운 용액을 찾는다.

    O(NlogN)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            list.add(tmp);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < n - 1; i++) {
            int sum = Math.abs(list.get(i) + list.get(i + 1));

            if (sum < min) {
                min = sum;
                idx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (list.get(idx) < list.get(idx + 1)) {
            sb.append(list.get(idx) + " " + list.get(idx + 1));
        } else {
            sb.append(list.get(idx + 1) + " " + list.get(idx));
        }

        System.out.println(sb);
    }
}