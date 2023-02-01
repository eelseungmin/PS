import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    /*
    O(NlogN)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        HashMap<Integer, int[]> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i],
                    new int[]{map.getOrDefault(arr[i], new int[]{0, i})[0] + 1,
                            map.getOrDefault(arr[i], new int[]{0, i})[1]});
        }

        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1)[0] == map.get(o2)[0]) { // 빈도가 같으면 처음 등장한 순서 기준 정렬
                    return map.get(o1)[1] - map.get(o2)[1];
                } else { // 빈도가 다르면 빈도가 많은 순서대로 정렬
                    return map.get(o2)[0] - map.get(o1)[0];
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a + " ");
        }

        System.out.println(sb);
    }
}