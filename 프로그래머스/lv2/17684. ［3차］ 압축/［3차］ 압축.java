import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        // 사전 초기화
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(((char)('A' +  i))), i + 1);
        }
        
        while (msg.length() != 0) {
            String cur = msg;
            String next = "";
            
            while (!map.containsKey(cur)) {
                next = cur.substring(cur.length() - 1); // 다음 글자 미리 저장
                cur = cur.substring(0, cur.length() - 1); // 끝에서부터 하나씩 자르기
            }
            
            ans.add(map.get(cur)); // 색인 번호 출력
            map.put(cur + next, map.size() + 1); // 현재 문자열 + 다음 글자 사전에 등록
            msg = msg.substring(cur.length());
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}