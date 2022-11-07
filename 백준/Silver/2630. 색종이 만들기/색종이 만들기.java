import java.io.*;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    /*
    1초, 128MB

    n*n, n=2^k
    N은 2, 4, 8, 16, 32, 64, 128 중 하나

    func
    base case: check를 돌려서 true(잘라진 종이가 모두 하얀색 또는 모두 파란색으로 칠해져 있거나, 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때)가 나오면 종료

    check
    탐색을 시작, 첫 원소와 현재 원소가 다르면 바로 false 반환
    */
    static Queue<Node> q;
    static int[][] paper;
    static int blue, white;

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(n, 0, 0);
        System.out.print(white + "\n" + blue);
    }

    public static boolean check(int n, int r, int c) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (paper[r][c] != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void func(int n, int r, int c) {
        if (check(n, r, c)) {
            switch (paper[r][c]) {
                case 0:
                    white++;
                    break;
                case 1:
                    blue++;
                    break;
            }
            return;
        }

        int half = n / 2;
        func(n / 2, r, c);
        func(n / 2, r, c + half);
        func(n / 2, r + half, c);
        func(n / 2, r + half, c + half);
    }
}