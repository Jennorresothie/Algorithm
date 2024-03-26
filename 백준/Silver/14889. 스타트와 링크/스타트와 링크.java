import java.io.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int n, stat[][], team[][] = new int[2][11], ret=INF;


    static int compare(){
        int team1, team2;
        team1 = team2 = 0;
        for(int i=0; i<n/2; i++) {
            for(int j=0; j<n/2; j++) {
                if(i!=j) {
                    team1 += stat[team[0][i]][team[0][j]];
                    team2 += stat[team[1][i]][team[1][j]];
                }
            }
        }
        return Math.abs(team1-team2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        stat = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] strs = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                stat[i][j] = Integer.parseInt(strs[j]);
        }

        long child=n, parent=n/2;
        for(int i=1; i<n/2; i++){
            child*=(n-i);
            parent*=i;
        }
        int cnt=(int)(child/parent)/2;

        for(int i=0; i<(1<<n); i++) {
            if(cnt==0) break;
            if(bitCheck(i)==n/2) {
                int ind, arr, arr2;
                ind = arr = arr2 = 0;
                for(int j=1; j<(1<<n); j*=2){
                    if((i&j)>0) team[0][arr++] = ind++;
                    else team[1][arr2++] = ind++;
                }
                ret = Math.min(ret,compare());
                cnt--;
            }
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
    static int bitCheck(int num) {
        int cnt = 0;
        for(int i=1; i<(1<<n); i*=2) {
            if((num&i)>0) cnt++;
        }
        return cnt;
    }
}