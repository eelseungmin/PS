import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = new String[5];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.next();
            max = Math.max(max, arr[i].length());
        }

        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        while (pointer < max) {
            for (int i = 0; i < 5; i++) {
                if (arr[i].length() > pointer) {
                    sb.append(arr[i].charAt(pointer));
                }
            }
            pointer++;
        }

        System.out.println(sb);
    }
}