import java.io.*;
import java.util.*;

public class Main {
    /*
    커서가 문장 맨 앞쪽에 위치하는 경우를 위해서 -1 인덱스가 있다고 가정한다.
    커서 왼쪽 문자를 지운다면(B)
    1. 해당 위치의 문자를 지운다. a b c
    2. 커서의 위치를 -1(list 전체 사이즈도 -1 됐으므로)
    커서 왼쪽에 문자를 추가한다면(P)
    1. 커서를 1 증가시킨다.
    2. 해당 커서 위치에 문자를 추가한다.

    time O(N+(N+M)^2) -> 시간 초과
    -> LinkedList에서 삽입, 삭제는 해당 위치의 주소를 알고 있을 경우에만 O(1)이고
    index를 이용한 삽입, 삭제는 해당 주소까지 찾아가야 하므로 O(N)이다. ListIterator을 이용하면 list의 주소를 이용할 수 있다.

    time O(N+M)
     */
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new LinkedList<>();

        String str = br.readLine(); // 맨 처음 문자열

        for (int i = 0; i < str.length(); i++) { // O(N)
            list.add(str.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();

        while (iter.hasNext()) {
            iter.next();
        }

        int inst = Integer.parseInt(br.readLine()); // 명령어의 갯수
        for (int i = 0; i < inst; i++) { // O(M)
            String subStr = br.readLine();
            char ch = subStr.charAt(0);

            switch (ch) {
                case 'L':
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'D':
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'P':
                    iter.add(subStr.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : list) {
            sb.append(ch);
        }

        System.out.println(sb.toString());
    }
}