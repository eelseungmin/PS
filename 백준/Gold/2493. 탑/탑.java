import java.io.*;
import java.util.*;

class Tower {
    int num;
    int height;

    public Tower(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

public class Main {
    /*
    1.5초 128MB
    4.5~7.5억번 3천만개

    1. 스택이 비어있으면 0 출력, 현재 탑 push
    2. 스택이 비어있지 않으면 다음 케이스 검사
    3-1. 현재 탑의 높이보다 peek의 높이가 높다면 해당 탑의 번호 출력 후 현재 탑 push
    3-2. 현재 탑의 높이보다 peek의 높이가 낮다면 pop한 후 2번으로 돌아간다.
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) { // 가장 왼쪽 탑
                sb.append(0 + " ");
                stack.push(new Tower(i + 1, height));
            } else {
                while (true) { // 현재 탑보다 높은 탑을 찾을 때까지
                    if (stack.isEmpty()) { // 현재 탑보다 높은 탑이 더 이상 존재하지 않으면
                        sb.append(0 + " ");
                        stack.push(new Tower(i + 1, height));
                        break;
                    }

                    if (stack.peek().height > height) {
                        sb.append(stack.peek().num + " ");
                        stack.push(new Tower(i + 1, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb);
    }
}