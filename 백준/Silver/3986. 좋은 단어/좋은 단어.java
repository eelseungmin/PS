import java.io.*;
import java.util.*;

public class Main {
    /*
    abab 스택에 2개 들어간 상황에서 3번째에 peek != ch
    babbab 스택에 3개 들어간 상황에서 4번째에 peek == ch
    bababbabab
    문자열을 다 읽었는데 스택에 문자가 남아있으면 좋은 글자 x
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            Stack<Character> s = new Stack<>();
            String str = br.readLine();

            for (char c : str.toCharArray()) {
                if (s.isEmpty()) {
                    s.push(c);
                } else {
                    if (s.peek() == c) {
                        s.pop();
                    } else {
                        s.push(c);
                    }
                }
            }

            if (s.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
