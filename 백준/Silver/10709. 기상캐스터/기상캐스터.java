import java.io.*;
import java.util.*;

public class Main {
    static int n,m, timeMap[][];
    static String clouds[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        clouds = new String[n];
        timeMap = new int[n][m];

        for(int i=0;i<n; i++){
            clouds[i] = br.readLine();
            //배열 초기화
            Arrays.fill(timeMap[i],-1);
        }

        for(int i=m-1; i>-1; i--){
            for(int j=0; j<n; j++) {
                if(timeMap[j][i]>=0)
                    continue;

                if(clouds[j].charAt(i)=='c') {
                    timeMap[j][i] = 0;
                    int b = i+1, val = 1;
                    while (b<m&&timeMap[j][b]==-1){
                        timeMap[j][b++] = val++;
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for (int j : timeMap[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}