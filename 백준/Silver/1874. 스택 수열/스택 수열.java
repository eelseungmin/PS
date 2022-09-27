import java.io.*;
import java.util.*;

public class Main {
    /*
    수열 4 3 6 8 7 5 2 1
    stack 1 2 5 6
    1. 숫자를 하나 입력 받는다.
    2. 해당 숫자까지 스택에 push한다.
    3. 해당 숫자가 수열에 들어가도록 pop한다.
    4. 다음 숫자를 입력 받는다.
    5. 해당 숫자가 더 크면 다시 해당 숫자까지 스택에 push한다.
    6. pop한다.
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        int last = 0; // 마지막으로 스택에 push한 숫자
        int cnt = 0; // 모든 과정을 마친 후 cnt != n -> NO
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (!stack.isEmpty()) {
                if (stack.peek() == temp) {
                    stack.pop();
                    cnt++;
                    list.add('-');
                    continue;
                }
            }

            if (last < temp) {
                for (int j = last + 1; j <= temp; j++) {
                    stack.push(j);
                    list.add('+');
                }
                last = temp;
            }

            if (stack.pop() == temp) { // 스택에서 꺼낸 숫자가 입력 받은 숫자와 일치
                cnt++;
            }
            list.add('-');
        }

        if (cnt == n) {
            for (char ch : list) {
                System.out.println(ch);
            }
        } else {
            System.out.println("NO");
        }
    }
}
