import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(stack.size() + "\n");
                    break;
                case "empty":
                    if (!stack.isEmpty()) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                    sb.append("\n");
                    break;
                case "top":
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}