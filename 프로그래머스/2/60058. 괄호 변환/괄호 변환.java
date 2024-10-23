import java.util.*;
class Solution {
    int pos;
    // 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
    // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    boolean isCorrect (String w) {
        int cnt = 0;
        Deque<Character> stack = new LinkedList<>();
        boolean ret = true;
        
        for (int i=0; i<w.length(); i++) {
            if(w.charAt(i)=='(') {
                cnt++;
                stack.add('(');
            } else {
                cnt--;
                if(stack.isEmpty()) ret = false;
                else stack.pop();
            }
            
            if(cnt==0) {
                pos = i + 1;
                return ret;
            } 
        }
        return ret;
    }
    
    public String solution(String p) {
        // 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(p.isEmpty()) return p;
        
        // 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        boolean flag = isCorrect(p);
        StringBuilder u = new StringBuilder(p.substring(0, pos));
        StringBuilder v = new StringBuilder(p.substring(pos));
        
        // 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if(flag) return u.append(solution(v.toString())).toString();
        
        // 문자열 u가 "올바른 괄호 문자열"이 아닐때, 빈 문자열에 첫 번째 문자로 '('를 붙입니다.  
        StringBuilder answer = new StringBuilder("(");
        
        // 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. ')'를 다시 붙입니다.
        answer.append(solution(v.toString())).append(")");
        
        // u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        for (int i=1; i<u.length()-1; i++) {
            if(u.charAt(i)=='(') answer.append(")");
            else answer.append("(");
        }
        
        return answer.toString();
    }
}