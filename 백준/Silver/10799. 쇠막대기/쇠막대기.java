import java.io.*;
import java.util.*;

public class Main {
    /*
    (.)((((.)(.))((.))(.)))((.))
    (는 push
    )는 이전 문자가 (면 레이저, )면 막대기
    레이저가 나가는 순간의 스택의 길이만큼 더하고
    막대기가 끝나면 해당 막대기는 1개만큼만 더 나오니까 +1
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') { // (
                s.push(ch);
            } else { // )
                if (str.charAt(i - 1) == '(') { // 레이저
                    s.pop();
                    cnt += s.size();
                } else { // 막대기 끝
                    s.pop();
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}