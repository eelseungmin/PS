import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    /*
    stack의 모습
    1. C B A
    2. B*C A
    3. B*C+A
    4. E D B*C+A
    5. D/E B*C+A
    6. (B*C+A)-(D/E)
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); // 후위 표기식
        sb.append(br.readLine());
        double[] operand = new double[n]; // 대응값 배열
        for (int i = 0; i < n; i++) {
            operand[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if ('A' <= ch && ch <= 'Z') { // 피연산자
                stack.push(operand[ch - 'A']);
            } else { // 연산자
                double b = stack.pop();
                double a = stack.pop();
                double res = calc(ch, a, b);
                stack.push(res);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }

    public static double calc(char operator, double a, double b) {
        double res = 0.0;

        switch (operator) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
        }

        return res;
    }
}