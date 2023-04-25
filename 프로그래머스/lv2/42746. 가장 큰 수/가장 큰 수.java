import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        // Arrays.sort(nums, new Comparator<String>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         return (s2 + s1).compareTo(s1 + s2);
        //     }
        // });
        Arrays.sort(nums, (s1, s2) -> 
           (s2 + s1).compareTo(s1 + s2)
        );
        
        if (nums[0].equals("0")) {
            return "0";
        }
            
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        
        return sb.toString();
    }
}