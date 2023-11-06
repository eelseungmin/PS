import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String tmp = sc.nextLine();

            String[] tmpArr = tmp.split(" ");
            String s = tmpArr[0];
            String t = tmpArr[1];

            int idx = 0;
            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                if (idx < s.length() && s.charAt(idx) == t.charAt(i)) {
                    count++;
                    idx++;
                }
            }

            if (count == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}