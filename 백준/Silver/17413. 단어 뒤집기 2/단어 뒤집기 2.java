import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*

     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                while (str.charAt(i) != '>') sb.append(str.charAt(i++));
                sb.append('>');
            } else if (str.charAt(i) == ' ') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(' ');
            } else {
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}