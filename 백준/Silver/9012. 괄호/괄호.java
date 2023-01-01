import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String tmp = br.readLine();
            boolean noFlag = false;
            Stack stack = new Stack();

            for (int j = 0; j < tmp.length(); j++) {
                char ch = tmp.charAt(j);

                if (ch == '(') {
                    stack.push(ch);
                } else { // )
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        noFlag = true;
                        break;
                    }
                }
            }
            if (!stack.isEmpty() || noFlag) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
    }
}