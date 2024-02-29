import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, k, string[], alpabet, ret;

    static void dfs(int depth, int word, int index){
        if(depth>=k){
            int cnt=0;
            for(int i : string) {
                int temp = i & word;
                if (temp == i)
                    cnt++;
            }
            ret = Math.max(ret,cnt);

            return;
        }

        for(int i=index; i<26; i++){
            if((word&(1<<i))==0)
                dfs(depth+1, word|(1<<i), i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        string = new int[n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(char c : str.toCharArray())
                string[i] |= (1<<c-'a');
        }

        if(k<5)
            System.out.println(0);
        else {
            for(char c : "antic".toCharArray()){
                alpabet |= (1<<c-'a');
                k--;
            }
            dfs(0, alpabet, 1);
            System.out.println(ret);
        }


    }
}