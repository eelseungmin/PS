import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (true) {
            String tmp = sc.nextLine();
            if (tmp.equals("END")) {
                break;
            }

            char[] arr = tmp.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                st.push(arr[i]);
            }
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}