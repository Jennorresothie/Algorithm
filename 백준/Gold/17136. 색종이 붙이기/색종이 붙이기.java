import java.util.*;
import java.io.*;
public class Main {
    static boolean map[][] = new boolean[10][10], visit[][] = new boolean[10][10];
    static int ret = Integer.MAX_VALUE, paper[] = new int[]{0,5,5,5,5,5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<10; j++)
                map[i][j]=Integer.parseInt(st.nextToken())==1?true:false;
        }

        dfs(0,0,0);
        bw.write((ret==Integer.MAX_VALUE?-1:ret)+"");
        bw.flush();
        bw.close();
    }

    static void dfs(int y, int x, int cnt) {

        if(cnt>=ret) return;
        if(x == 10) {
            dfs(y+1, 0, cnt);
            return;
        }
        if(y == 10) {
            ret = Math.min(cnt, ret);
            return;
        }
        if(!map[y][x]){
            dfs(y, x+1, cnt);
            return;
        }

        for(int size=5; size >= 1; size-- ) {
            if(paper[size]==0) continue;

            if(check(y, x, size)) {
                paper[size]--;
                mark(y, x, size, false);
                dfs(y, x+size, cnt+1);
                mark(y, x, size, true);
                paper[size]++;
            }
        }

    }

    static boolean check(int y, int x, int size) {
        if(y+size>10 || x+size>10)
            return false;

        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                if(!map[y+i][x+j])
                    return false;

        return true;
    }

    static void mark(int y, int x, int size, boolean mask) {
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                map[y+i][x+j] = mask;
    }
}