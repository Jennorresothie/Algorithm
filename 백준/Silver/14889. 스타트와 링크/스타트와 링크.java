import java.io.*;

public class Main {
    static int n, total, row[] = new int[20], col[] = new int[20], ret=987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                int v = Integer.parseInt(str[j]);
                total += v;
                row[i] += v;
                col[j] += v;
            }
        }
        match(1,1, total-row[0]-col[0]);
        bw.write(String.valueOf(ret));
        bw.close();
    }
    static void match(int ind, int depth, int cur) {
        if(depth==n/2) {
            ret = Math.min(ret, Math.abs(cur));
            return;
        }
        if(ind==n) return;
        match(ind+1, depth+1, cur-row[ind]-col[ind]);
        match(ind+1, depth, cur);
    }
}