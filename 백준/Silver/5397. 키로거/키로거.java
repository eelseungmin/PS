import java.io.*;
import java.util.*;

public class Main {
    /*
    문자열을 앞에서부터 읽는다.
    문자를 만나면 list.add
    <, >를 만나면 커서 이동(아무 문자도 없거나 이동할 수 없을 때는 무시)
    -를 만나면 커서 왼쪽 문자 삭제

    time O(N*L)
     */
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String str = br.readLine();

            List<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                switch (ch) {
                    case '<':
                        if (list.size() != 0 && iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (list.size() != 0 && iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(ch);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : list) {
                sb.append(ch);
            }

            System.out.println(sb.toString());
        }

    }
}