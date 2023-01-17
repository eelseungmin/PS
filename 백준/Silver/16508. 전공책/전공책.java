import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Book {
    int price;
    String title;

    public Book(int price, String title) {
        this.price = price;
        this.title = title;
    }
}

public class Main {
    /*
    이 책을 고르냐 안 고르냐
    -> 백트래킹
    골랐다면 필요한 알파벳이 포함되어 있는지 확인
     */
    static String wanted;
    static int[] wantedArr;
    static int[] selectArr;
    static int n;
    static ArrayList<Book> books;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wanted = br.readLine();
        wantedArr = new int[26];
        selectArr = new int[26];
        n = Integer.parseInt(br.readLine());
        books = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < wanted.length(); i++) {
            wantedArr[wanted.charAt(i) - 'A']++;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            books.add(new Book(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        dfs(0, 0);

        if (ans != Integer.MAX_VALUE) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    static void dfs(int cnt, int sum) {
        if (cnt == n) {
            if (check()) {
                ans = Math.min(ans, sum);
            }
            return;
        }

        Book cur = books.get(cnt);
        String title = cur.title;
        int price = cur.price;

        for (int i = 0; i < title.length(); i++) {
            selectArr[title.charAt(i) - 'A']++;
        }
        dfs(cnt + 1, sum + price);

        for (int i = 0; i < title.length(); i++) {
            selectArr[title.charAt(i) - 'A']--;
        }
        dfs(cnt + 1, sum);
    }

    static boolean check() {
        for (int i = 0; i < selectArr.length; i++) {
            if (selectArr[i] >= wantedArr[i]) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}