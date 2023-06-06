import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i = 0; i<n; i++){
            String str = br.readLine();

            for(int j=0;j<str.length();j++){
                map[i][j] = str.charAt(j);
            }
        }

        int stand = n>m?m:n;

        for(int i = stand; i>=1; i--){
            if(i==1){
                System.out.println(1);
                break;
            }
            int r = find(i);
            if(r!=0){
                System.out.println(r*r);
                break;
            }
        }

    }

    static int find(int s){

        for(int i = 0; i<=n-s; i++){
            for(int j=0;j<=m-s;j++){
                if(map[i][j]==map[i+(s-1)][j]&&
                        map[i][j]==map[i][j+(s-1)]&&
                        map[i][j]==map[i+(s-1)][j+(s-1)])
                return s;
            }
        }

        return 0;
    }
}