import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            res.add(i + 1);
        }

        sb.append("<");

        while(!res.isEmpty()) {
            for (int j = 0; j < k - 1; j++) {
                res.add(res.remove(0));
            }
            int num = res.remove(0);

            if (res.size() != 0) {
                sb.append(num + ", ");
            } else {
                sb.append(num + ">");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
i 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. 7 3
o <3, 6, 2, 7, 5, 1, 4>
c (1 ≤ K ≤ N ≤ 5,000)
e

solution
1.
1 2 3/ 4 5 6 7
1 2 4 5 6/ 7
1 2/ 4 5 7
1 4 5 7/
1 4 5/
1/ 4
4/
x

queue 사용
list가 빌 때까지 반복
k번이 되면 list에서 삭제, k번이 아니라면 삭제 후 재삽입

time O(n)
space O(n)
 */