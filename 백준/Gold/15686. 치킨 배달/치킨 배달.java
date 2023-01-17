import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] city;
    static ArrayList<Position> home;
    static ArrayList<Position> chicken;
    static int ans; // 최종 치킨 거리
    static boolean[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    home.add(new Position(i, j));
                } else if (city[i][j] == 2) {
                    chicken.add(new Position(i, j));
                }
            }
        } // input
        list = new boolean[chicken.size()];

        findSubset(0, 0);

        System.out.println(ans);
    }

    static void findSubset(int start, int cnt) {
        if (cnt == m) {
            int cityMin = calcMin();
            ans = Math.min(ans, cityMin);

            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            list[i] = true;
            findSubset(i + 1, cnt + 1);
            list[i] = false;
        }
    }

    static int calcMin() {
        int cityMin = 0; // 해당 조합에서의 도시 치킨 거리

        for (int i = 0; i < home.size(); i++) {
            int min = Integer.MAX_VALUE; // 해당 집의 치킨 거리

            for (int j = 0; j < chicken.size(); j++) {
                if (list[j]) {
                    int tmp = Math.abs(home.get(i).x - chicken.get(j).x)
                            + Math.abs(home.get(i).y - chicken.get(j).y);

                    min = Math.min(min, tmp);
                }
            }

            cityMin += min;
        }

        return cityMin;
    }
}