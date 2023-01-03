import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        int last = 0; // last push
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (last < num) {
                while (last != num) {
                    stack.push(++last);
                    sb.append('+').append('\n');
                }
            }

            if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}