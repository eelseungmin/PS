import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        String input = sc.next();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Integer.parseInt(input.charAt(i) + "");
        }

        System.out.println(res);
    }
}