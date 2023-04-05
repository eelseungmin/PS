import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        // 팩토리얼 미리 계산
        long[] factorial = new long[n];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        
        ArrayList<Integer> num = new ArrayList<>(); // 번호를 담아둘 리스트
        for (int i = 0; i < n; i++) {
            num.add(i + 1);
        }
        int[] ans = new int[n]; // 정답
        long K = k - 1;
        int N = n;
        for (int i = 0; i < n; i++) {
            int idx = (int) (K / factorial[N - 1]);
            ans[i] = num.get(idx);
            num.remove(idx);
            K = K % factorial[N - 1];
            N--;
            
        }
        
        return ans;
    }
}