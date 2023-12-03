import java.io.*;
import java.util.*;
public class Main {
    private static List<Integer>[] list = new LinkedList[51];
    static int req;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        req = Integer.parseInt(br.readLine());

        int s = 0;

        for(int i=0; i<51; i++){
            list[i] = new LinkedList<>();
        }

        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp == -1)
                s = i;
            else {
                list[temp].add(i);
            }
        }

        if (s == req) {
            System.out.println(0); // If the root node is the removal target, the result is 0
        } else {
            System.out.println(dfs(s));
        }
    }

    private static int dfs(int num) {
        int ret = 0;
        int child = 0;

        for(int n : list[num]){
            if(n==req)
                continue;
            ret+=dfs(n);
            child++;
        }

        return child==0?1:ret;
    }
}