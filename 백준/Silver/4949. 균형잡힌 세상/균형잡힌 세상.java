import java.io.*;
import java.util.*;

public class Main {
    /*
    1. 문자열을 입력 받는다.
    2. (, {, [이면 스택에 넣는다.
    3. 닫는 괄호들을 만났을 때
    3-1. 스택이 비어 있으면 no를 출력하고 다음 문자열로 넘어간다.
    3-1. 짝이 맞지 않으면 no를 출력하고 다음 문자열로 넘어간다.
    3-2. 짝이 맞으면 이어서 다음 문자를 확인한다.
    4. 탐색이 끝났을 때 스택의 크기가 0이 아니면 no를 출력한다.
    4-1. 0이면 yes를 출력한다.
    5. 계속해서 확인한다.
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            boolean isValid = true;
            for (char ch : str.toCharArray()) {
                switch (ch) {
                    case '(': case '{': case '[':
                        stack.push(ch);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') {
                            isValid = false;
                        } else {
                            stack.pop();
                        }
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') {
                            isValid = false;
                        } else {
                            stack.pop();
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') {
                            isValid = false;
                        } else {
                            stack.pop();
                        }
                        break;
                }

                if (!isValid) {
                    break;
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}