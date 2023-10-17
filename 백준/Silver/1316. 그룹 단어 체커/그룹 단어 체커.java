import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        int[] lastIdx = new int[26]; // 알파벳 별로 마지막으로 나타난 idx 표시
        Arrays.fill(lastIdx, -1);

        int ans = 0;
        boolean flag = true;
        for (String str : arr) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (lastIdx[ch - 'a'] != -1 && i - lastIdx[ch - 'a'] != 1) {
                    flag = !flag;
                    break;
                }
                lastIdx[ch - 'a'] = i;
            }
            if (flag) {
                ans++;
            }
            Arrays.fill(lastIdx, -1);
            flag = true;
        }

        System.out.println(ans);
    }
}