import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    앞에서부터 재귀를 이용해 추가해나가는 방식은 가지치기가 되지 않으므로 시간초과
    따라서 t를 조건에 따라 줄여나가는 방식을 이용한다.
     */
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        func(t, s);

        if (cnt != 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void func(String t, String s) {
        if (t.length() == s.length()) { // 길이가 같으면 종료
            if (t.equals(s)) { // 문자열이 일치하면 cnt++
                cnt++;
            }
            return;
        }

        // 문자열의 맨 뒤가 A이면 빼기
        if (t.charAt(t.length() - 1) == 'A') {
            func(t.substring(0, t.length() - 1), s);
        }

        // 문자열의 맨 앞이 B이면 빼고 뒤집기
        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t.substring(1));
            func(sb.reverse().toString(), s);
        }
    }
}