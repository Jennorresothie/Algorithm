import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        Stack<int[]> s = new Stack<>();
        long ret=0;

        for(int i=0; i<n; i++) {
            int input =stoi(br.readLine());
            int cnt = 1;
            /*
            * Stack에 값이 있을때
            * input이 top보다 크거나 같을때
            * input 보다 더 큰값이나 Stack이 빌때까지
            * pop하며 ret을 증기시킨다
            * 마지막에 input은 Stack에 push */
            while(!s.empty()&&s.peek()[0]<=input) {
                if(s.peek()[0]<input)
                    cnt = 1;
                else { // 같을때
                    cnt = s.peek()[1]+1;
                }
                ret += s.pop()[1];
            }
            // top > input 일때 push하고 ret 증가
            if(!s.empty()) ret++;
            s.push(new int[]{input, cnt});
        }
        System.out.println(ret);
    }
    static int stoi(String str){
        return Integer.parseInt(str);
    }
}