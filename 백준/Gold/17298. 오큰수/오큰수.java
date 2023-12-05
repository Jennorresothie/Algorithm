import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] ret = new int[1000001];
    static int[] list = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.fill(ret,-1);

        int ind = 1;
        while(st.hasMoreTokens()){
            list[ind++] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(1);

        for(int i=2; i<=n; i++) {

            while(!stack.isEmpty()&&list[stack.peek()]< list[i]) {
                ret[stack.pop()] = list[i];
            }

            stack.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(ret[i]).append(' ');
        }

        System.out.println(sb);
    }
}