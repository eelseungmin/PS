import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /*
    사이클을 이루면 두 집합이 일치

    O(N^2)
     */
    static int n;
    static int[] arr;
    static boolean[] vis;
    static ArrayList<Integer> res; // 정답 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        vis = new boolean[n + 1];
        res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            vis[i] = true;
            dfs(i, i);
            vis[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(res);
        sb.append(res.size() + "\n");
        for (int num : res) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int cur, int target) {
        if (arr[cur] == target) { // 사이클 조건 충족
            res.add(target);
        }

        if (!vis[arr[cur]]) {
            vis[arr[cur]] = true;
            dfs(arr[cur], target);
            vis[arr[cur]] = false;
        }
    }
}