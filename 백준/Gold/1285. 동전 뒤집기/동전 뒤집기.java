import java.util.*;
import java.io.*;

public class Main {
    static int n, array[], ret =  Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        n = Integer.parseInt(br.readLine());
        array = new int[n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            //이진수 -> 십진수
            int bit = 1;
            for(char c : str.toCharArray()){
                if(c=='T') {
                    array[i]|=bit;
                }
                bit*=2;
            }
        }

        // 행만을 바꾸는 모든 경우의 수를 구함
        for(int i=0; i<(1<<n); i++){
            for(int j=0; j<n; j++) {
                if((i&(1<<j))!=0){
                    array[j]=~array[j];
                }
            }

            // 열의 T의 개수를 세서 가장 작을 경우의 합을 구해서 비교
            int sum=0;
            for(int j=1; j<=(1<<(n-1)); j*=2) {
                int cnt=0;
                for(int k=0; k<n; k++){
                    if((array[k]&j)>0) cnt++; // 열로 보면서 T 개수 카운트
                }
                sum+=Math.min(cnt, n-cnt);
            }
            ret=Math.min(sum, ret);

            for(int j=0; j<n; j++) {
                if((i&(1<<j))!=0){
                    array[j]=~array[j];
                }
            }
        }

        System.out.println(ret);

    }
}