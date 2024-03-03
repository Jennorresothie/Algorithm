import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ret, box[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=stoi(st.nextToken());
        m=stoi(st.nextToken());

        box = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                box[i][j] = s.charAt(j)-'0';
            }
        }

        for(int paper=0; paper<(1<<(n*m)); paper++){
            int sum=0;
            // 가로
            for(int i=0; i<n; i++){
                int temp=0;
                for(int j=0; j<m; j++){
                    int ind = i*m+j;

                    if((paper&(1<<ind))==0){
                        temp = temp*10+box[i][j];
                    }
                    else{
                        sum+=temp;
                        temp=0;
                    }
                }
                sum+=temp;
            }
            // 세로
            for(int i=0; i<m; i++){
                int temp=0;
                for(int j=0; j<n; j++){
                    int ind = j*m+i;

                    if((paper&(1<<ind))!=0){
                        temp = temp*10+box[j][i];
                    }
                    else{
                        sum+=temp;
                        temp=0;
                    }
                }
                sum+=temp;
            }

            ret = Math.max(ret, sum);
        }
        System.out.println(ret);
    }
    static int stoi(String str){
        return Integer.parseInt(str);
    }
}