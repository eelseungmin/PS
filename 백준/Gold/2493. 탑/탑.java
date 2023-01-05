import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

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
    탑 높이 push
    6 9 5 7 4 3 8 6
    6
    9
    모든 탑을 돌면서 다 push를 하되
    이번 탑의 높이 > peek일 동안 계속 pop
    이번 탑의 높이 <= peek일 경우 peek의 높이 출력
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            Tower cur = new Tower(i + 1, Integer.parseInt(st.nextToken()));

            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    if (cur.height > stack.peek().height) {
                        stack.pop();
                    } else {
                        break;
                    }
                }

                if (!stack.isEmpty()) {
                    sb.append(stack.peek().num).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            } else {
                sb.append(0).append(" ");
            }
            stack.push(cur);
        }

        System.out.println(sb);
    }
}
