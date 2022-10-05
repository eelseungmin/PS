import java.io.*;
import java.util.*;

public class Main {
    /*
    1초, 128
    괄호 내부의 값 tmp
    전체 값 res
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        int tmp = 1; // 더하기 변수
        int res = 0; // 곱하기 변수

        for (int i = 0; i < str.length(); i++) {
            if (!isValid) { // 틀린 괄호열이면 반복문 바로 탈출
                break;
            }
            char ch = str.charAt(i);

            switch (ch) {
                case '(':
                    stack.push(ch);
                    tmp *= 2;

                    break;
                case '[':
                    stack.push(ch);
                    tmp *= 3;

                    break;
                case ')':
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }

                    if (str.charAt(i - 1) == '(') {
                        res += tmp;
                    }
                    tmp /= 2;

                    if (stack.pop() != '(') {
                        isValid = false;
                    }

                    break;
                case ']':
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }

                    if (str.charAt(i - 1) == '[') {
                        res += tmp;
                    }
                    tmp /= 3;

                    if (stack.pop() != '[') {
                        isValid = false;
                    }

                    break;
            }
        }

        if (!stack.isEmpty()) {
            isValid = false;
        }
        if (!isValid) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }
}