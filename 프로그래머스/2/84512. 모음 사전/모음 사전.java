import java.util.*;

class Solution {
    static char[] aeiou = {'A', 'E', 'I', 'O', 'U'};
    static int[] permu;
    static int max;
    static List<String> dict;
    
    public int solution(String word) {
        /**
        중복순열로 해결
        **/
        permu = new int[aeiou.length];
        dict = new ArrayList<>();
    
        for (int i = 1; i <= aeiou.length; i++) {
            max = i;
            choose(0);
        }
        Collections.sort(dict);
        for (int j = 0; j < dict.size(); j++) {
            if (dict.get(j).equals(word)) return j + 1;
        }
        
        return -1;
    }
    
    public void choose(int idx) {
        if (idx == max) {
            String newWord = "";
            for (int i = 0; i < max; i++) {
                newWord += aeiou[permu[i]] + "";
            }
            dict.add(newWord);
            return;
        }
        
        for (int i = 0; i < aeiou.length; i++) {
            permu[idx] = i;
            choose(idx + 1);
        }
    }
}