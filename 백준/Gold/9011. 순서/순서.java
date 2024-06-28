import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int array[] = new int[101];
        boolean flag[] = new boolean[101];
        int t = Integer.parseInt(br.readLine());
        for(int test=0; test<t; test++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) array[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(flag, 1,n+1,false);
            int answer[] = new int[n+1];
            int top = n;
            boolean print = false;
            for(int i=n-1; i>=0; i--) {
                if(i<array[i]) {
                    print = true;
                    break;
                }
                int move = i - array[i];
                int cur = top+1;
                while(move>=0) {
                    cur--;
                    if(flag[cur]) continue;
                    else move--;
                }
                flag[cur]=true;
                answer[i] = cur;
            }
            if(print) bw.write("IMPOSSIBLE\n");
            else {
                for(int i=0; i<n; i++) bw.write(String.valueOf(answer[i])+" ");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}