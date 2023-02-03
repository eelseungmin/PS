import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Title {
    String name;
    int power;

    public Title(String name, int power) {
        this.name = name;
        this.power = power;
    }
}

public class Main {
    /*
    m개의 캐릭터마다 n개의 칭호를 다 살펴보려면 O(NM) -> 시간초과
    시간복잡도를 줄이려면 한 가지를 이분탐색으로
    칭호는 전투력이 정렬된 상태로 입력이 들어오므로 정렬을 따로 해줄 필요는 없다.

    O(MlogN)
     */
    static int n, m;
    static Title[] titles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        titles = new Title[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = new Title(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(titles[bSearch(power)].name + "\n");
        }

        System.out.println(sb);
    }

    public static int bSearch(int power) { // 현재 보고 있는 캐릭터의 전투력과 비교해 전투력이 크거나 같은 칭호 중 앞에 있는 것의 idx return
        int left = 0;
        int right = n - 1;

        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (titles[mid].power >= power) { // 현재 보고 있는 캐릭터의 전투력보다 탐색된 칭호의 전투력이 크거나 같으면
                idx = mid;
                right = mid - 1;
            } else { // 작으면
                left = mid + 1;
            }
        }

        return idx;
    }
}