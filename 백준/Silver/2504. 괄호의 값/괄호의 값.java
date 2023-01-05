import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*
    (()[[]]) ([])
    2(2+3(3))+2(3)
    2*2 + 2*3(3) + 2(3)
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int ans = 0; // 전체 계산 결과
        int tmp = 1;
        Stack<Character> par = new Stack<>();
        boolean isValid = true; // 문자열 유효 여부

        for (int i = 0; i < input.length(); i++) {
            if (!isValid) {
                break;
            }
            char cur = input.charAt(i);

            switch (cur) {
                case '(':
                    par.push(cur);
                    tmp *= 2;
                    break;
                case '[':
                    par.push(cur);
                    tmp *= 3;
                    break;
                case ')':
                    if (par.isEmpty()) {
                        isValid = false;
                        break;
                    }

                    if (input.charAt(i - 1) == '(') {
                        ans += tmp;
                    }
                    tmp /= 2;

                    if (par.pop() != '(') {
                        isValid = false;
                    }

                    break;
                case ']':
                    if (par.isEmpty()) {
                        isValid = false;
                        break;
                    }

                    if (input.charAt(i - 1) == '[') {
                        ans += tmp;
                    }
                    tmp /= 3;

                    if (par.pop() != '[') {
                        isValid = false;
                    }

                    break;
            }
        }

        if (!isValid || !par.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}