import java.io.*;
public class Main {
    static int n, box[][], ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        box = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] strs = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                box[i][j] = Integer.parseInt(strs[j]);
                ret = Math.max(ret, box[i][j]);
            }
        }
        dfs(box,0);
        bw.write(String.valueOf(ret));
        bw.close();
    }

    static void dfs(int [][]map, int depth) {
        if(depth==5) return;

        for(int d=0; d<4; d++) dfs(move(map, d), depth+1);
    }

    static int[][] move(int[][] map, int d) {
        int[][] temp = new int[n][n];
        if(d==0) {// 위 -> 아래
            for (int i = 0; i < n; i++) {
                int base = -1, ind = 0;
                for (int j = 0; j < n; j++) {
                    if (map[j][i] == 0) continue;
                    if (map[j][i] == base) {
                        temp[ind - 1][i] <<= 1;
                        ret = Math.max(ret, temp[ind - 1][i]);
                        base = -1;
                    } else
                        temp[ind++][i] = base = map[j][i];
                }
            }
        }
        else if(d==1) {
            for(int i=0; i<n; i++) {
                int base = -1, ind = n-1;
                for(int j=n-1; j>=0; j--) {
                    if(map[j][i]==0) continue;
                    if(map[j][i]==base) {
                        temp[ind+1][i] <<=1;
                        ret = Math.max(ret, temp[ind+1][i]);
                        base = -1;
                    }
                    else
                        temp[ind--][i] = base = map[j][i];
                }
            }
        } else if (d==2) {
            for(int i=0; i<n; i++) {
                int base = -1, ind = n-1;
                for(int j=n-1; j>=0; j--) {
                    if(map[i][j]==0) continue;
                    if(map[i][j]==base) {
                        temp[i][ind+1] <<=1;
                        ret = Math.max(ret, temp[i][ind+1]);
                        base = -1;
                    }
                    else
                        temp[i][ind--] = base = map[i][j];
                }
            }
        }
        else {
            for(int i=0; i<n; i++) {
                int base = -1, ind = 0;
                for(int j=0; j<n; j++) {
                    if(map[i][j]==0) continue;
                    if(map[i][j]==base) {
                        temp[i][ind-1] <<=1;
                        ret = Math.max(ret, temp[i][ind-1]);
                        base = -1;
                    }
                    else
                        temp[i][ind++] = base = map[i][j];
                }
            }
        }
        return temp;
    }
}