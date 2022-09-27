import java.io.*;
import java.util.*;

public class Main {
    /*
    time O(N)
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp != 0) {
                stack.push(temp);
            } else {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        System.out.println(res);
    }
}