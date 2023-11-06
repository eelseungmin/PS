import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String tmp = sc.next();
            if (tmp.equals("end")) {
                break;
            }

            if (first(tmp) && second(tmp) && third(tmp)) {
                System.out.print("<");
                System.out.println(tmp + "> is acceptable.");
                continue;
            }
            System.out.print("<");
            System.out.println(tmp + "> is not acceptable.");
        }
    }

    public static boolean first(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (special(ch)) {
                return true;
            }
        }
        return false;
    }

    public static boolean second(String s) {
        if (s.length() < 3) {
            return true;
        }
        for (int i = 2; i < s.length(); i++) {
            if (special(s.charAt(i - 2)) && special(s.charAt(i - 1)) && special(s.charAt(i))) {
                return false;
            }
            if (!special(s.charAt(i - 2)) && !special(s.charAt(i - 1)) && !special(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean third(String s) {
        if (s.length() < 2) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                if (s.charAt(i) == 'e' || s.charAt(i) == 'o') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean special(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}