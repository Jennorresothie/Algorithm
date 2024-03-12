import java.io.*;
import java.util.*;
public class Main {
    static long ret;
    static int head, end, nums[] = new int[100001];
    static boolean check[] = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());
        
        while(end<n){
            // 같은 수 만나면 head 증가
            if(check[nums[end]]) {
                ret += (end-head);
                check[nums[head]] = false;
                head++;
                continue;
            }
            // 아니면 end 증가
            check[nums[end++]] = true;
        }
        long temp = end - head + 1;
        ret += (temp*(temp-1)/2);
        System.out.println(ret);
    }
}