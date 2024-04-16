import java.io.*;

public class Main {
    static int n, arr[], max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, command[] = new int[4];
    static void dfs(int depth, int sum){
        if(depth==n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            if(command[i]==0) continue;
            command[i]--;
            dfs(depth+1, cal(depth, sum, i));
            command[i]++;
        }
    }

    static int cal(int ind, int num, int coms) {
        if(coms==0) return arr[ind]+num;

        else if(coms==1) return num-arr[ind];

        else if(coms==2) return num*arr[ind];

        else {
            boolean flag = false;
            if(num<0) {
                flag = true;
                num*=-1;
            }

            int temp = num/arr[ind];

            if(flag) temp*=-1;

            return temp;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(str[i]);
        str = br.readLine().split(" ");
        for(int i=0; i<4; i++) command[i] = Integer.parseInt(str[i]);

        dfs(1, arr[0]);

        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(min));
        bw.close();
    }
}