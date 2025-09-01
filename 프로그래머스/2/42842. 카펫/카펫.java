import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        /**
        가로 >= 세로
        3 3
        2(a-2) + 2(b-2) + 4 = brown 개수
        2a + 2b - 4 = brown 개수
        (a-2)*(b-2) = yellow 개수
        a
        **/
        
        for (int w = 1; w <= 10000; w++) {
            for (int h = 1; h <= 10000; h++) {
                if (w < h) continue;
                if (2 * (w + h) - 4 == brown && (w - 2) * (h - 2) == yellow) return new int[]{w, h};
            }
        }
        
        return new int[]{0,0};
    }
}