import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1; i<numbers.length; i++) {
            while(!s.isEmpty() && numbers[s.peek()] < numbers[i]) 
                answer[s.pop()] = numbers[i];
            s.push(i);
        }
        return answer;
    }
}