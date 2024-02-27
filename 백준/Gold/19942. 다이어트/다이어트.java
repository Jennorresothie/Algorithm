import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, box[][], ret=INF, smp, smf, sms, smv, ret2=65536;
    static boolean visited[];

    static boolean check(int mp, int mf, int ms, int mv){
        if(mp>=smp&&mf>=smf&&ms>=sms&&mv>=smv)
            return true;
        return false;
    }

    static void backTracking(int mp, int mf, int ms, int mv, int cnt, int bit, int ind){
        if(check( mp, mf, ms, mv)){
            if(ret>=cnt){
                if(ret>cnt) {
                    ret=cnt;
                    ret2=bit;
                }
                else
                    ret2 = Math.min(bit, ret2);
            }
            return;
        }

        for(int i=ind; i<=n; i++){
            if(visited[i])
                continue;
            if(cnt+box[i][4] >= ret )
                continue;

            visited[i]=true;
            bit |= (1<<(i-1));
            backTracking(mp+box[i][0],mf+box[i][1],ms+box[i][2], mv+box[i][3], cnt+box[i][4], bit, i);
            bit &= ~(1<<(i-1));
            visited[i]=false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        box = new int[n+1][5];
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        smp = Integer.parseInt(st.nextToken());
        smf = Integer.parseInt(st.nextToken());
        sms = Integer.parseInt(st.nextToken());
        smv = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                box[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0,0,0,0, 0,0, 1);

        if(ret !=INF){
            System.out.println(ret);
            String binary = Integer.toBinaryString(ret2);
            int size = binary.length();
            for(int i=size-1; i>-1; i--)
                if(binary.charAt(i)=='1')
                    System.out.print(size-i+" ");
        }
        else
            System.out.println(-1);


    }
}