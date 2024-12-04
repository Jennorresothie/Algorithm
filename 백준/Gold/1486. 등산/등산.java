import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m, t, d, arr[][] = new int[26][26], ret, list[], floid[][]=new int[2600][2600], dire[][] = {{1,0},{-1, 0},{0,1},{0,-1}};

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                if (str.charAt(j) >= 'a') arr[i][j] = str.charAt(j) - 'a' + 26;
                else arr[i][j] = str.charAt(j) - 'A';
            }
        }

        list = new int[n*m+1];
        ret = arr[0][0];
        int ind = 0;
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++) list[ind++] = i*100+j;

        for (int i=0; i<2600; i++) Arrays.fill(floid[i], 987654321);

        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                for (int k=0; k<4; k++) {
                    int ny = i + dire[k][0];
                    int nx = j + dire[k][1];

                    if (ny<0||ny>=n||nx<0||nx>=m) continue;

                    int dif = Math.abs(arr[i][j] - arr[ny][nx]);
                    if (dif <= t) {
                        if (arr[ny][nx] > arr[i][j]) floid[i*100+j][ny*100+nx] = dif*dif;
                        else floid[i*100+j][ny*100+nx] = 1;
                    }
                }

        for (int k : list)
            for (int i : list)
                for (int j : list)
                    floid[i][j] = Math.min(floid[i][j], floid[i][k] + floid[k][j]);

        for (int i : list)
            if (d >= floid[0][i] + floid[i][0])
                ret = Math.max(ret, arr[i/100][i%100]);

        bw.write(ret+"");
        bw.flush();
        bw.close();
        br.close();
    }
}