import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String k = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                sb.append(ch);
            }
        }

        if (sb.toString().contains(k)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}