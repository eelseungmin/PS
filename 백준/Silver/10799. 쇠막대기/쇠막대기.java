import java.io.*;
import java.util.*;

public class Main {
    /*
    ( -> push
    ) -> pop 이후 ans += stack.size()(바로 왼쪽 문자가 '('일 경우에만)
    바로 왼쪽 문자가 '('이 아니라면 ans += 1
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int ans = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if (cur == '(') {
                stack.push(cur);
            } else {
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }

}
