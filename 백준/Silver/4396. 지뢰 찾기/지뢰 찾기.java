import java.util.*;

public class Main {
    static int n;
    static char[][] bomb;
    static char[][] open;
    static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        bomb = new char[n][n];
        open = new char[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                bomb[i][j] = tmp.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                open[i][j] = tmp.charAt(j);
            }
        }

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (open[i][j] == 'x') {
                    if (bomb[i][j] == '*') {
                        open[i][j] = '*';
                        flag = true;
                    } else {
                        open[i][j] = String.valueOf(checkBomb(i, j)).charAt(0);
                    }
                }
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (bomb[i][j] == '*') {
                        open[i][j] = '*';
                    }
                }
            }
        }

        printMap();
    }

    public static int checkBomb(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (bomb[nx][ny] == '*') {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(open[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}