import java.util.*;

class Data {
    String word;
    int depth;
    
    Data(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        /**
        먼저 target이 words에 있는지 확인
        bfs를 이용해 탐색(현재 단어와 바꿀 단어의 알파벳 차이를 확인)
        탐색하며 최소값 갱신
        **/
        int ans = 0;
        boolean flag = false;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) flag = true;
        }
        if (!flag) return 0;
        
        Queue<Data> q = new LinkedList<>();
        boolean[] vis = new boolean[words.length];
        
        q.offer(new Data(begin, 0));
        
        while (!q.isEmpty()) {
            Data cur = q.poll();
            
            for (int i = 0; i < words.length; i++) {
                if (!vis[i] && checkChar(cur.word, words[i])) {
                    if (words[i].equals(target)) {
                        return cur.depth + 1;
                    }
                    vis[i] = true;
                    q.offer(new Data(words[i], cur.depth + 1));
                }
            }
        }
        
        return ans;
    }
    
    public boolean checkChar(String left, String right) {
        int diff = 0;
        
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) diff++;
        }
        
        if (diff != 1) return false;
        return true;
    }
}