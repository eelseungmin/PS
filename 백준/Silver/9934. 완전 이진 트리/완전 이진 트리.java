import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /*
    중위순회를 했을 때의 순서가 주어지면 각 레벨 별 빌딩 번호를 출력한다.
    문제를 읽어보면 자식을 하나만 가지는 경우는 존재하지 않는다는 걸 알 수 있다.

    0 1 2 3 4 5 6

    배열을 깊이 k까지 계속 절반으로 나누고
    재귀를 들어갈 때마다 depth가 1씩 늘어나도록 한 뒤 각 레벨에 번호를 추가한다.
     */

    static int k;
    static ArrayList<ArrayList<Integer>> level;
    static int[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        level = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            level.add(new ArrayList<>());
        }
        int total = (int) Math.pow(2, k) - 1; // 총 노드 갯수
        nodes = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        divide(0, 0, nodes.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < level.get(i).size(); j++) {
                sb.append(level.get(i).get(j) + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void divide(int lv, int l, int r) {
        if (lv == k) {
            return;
        }

        int mid = (l + r) / 2;

        level.get(lv).add(nodes[mid]);

        divide(lv + 1, l, mid - 1);
        divide(lv + 1, mid + 1, r);
    }
}