import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, arr[], ret=INF;

    static void bt(int depth){
        // 모든 행을 다 변경했다면
        if(depth>=n){
            // 열 단위로 확인하면서 T가 더 적은 것으로 T개수 계산
            int sum=0;
            for(int i=1; i<(1<<n); i*=2) {
                int cnt = 0;
                for(int j=0; j<n; j++){
                    if((arr[j]&i)>0)
                        cnt++;
                }
                sum += Math.min(cnt, n-cnt);
            }

            ret=Math.min(ret, sum);

            return;
        }

        bt(depth+1);
        arr[depth] = ~arr[depth];
        bt(depth+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        n=stoi(br.readLine());
        arr = new int[n];

        for(int i=0; i<n; i++){
            //  H : 0, T : 1 로 이진수로 보고 십진수로 변환
            int bit=1;
            String coin = br.readLine();
            for(char c : coin.toCharArray()){
                if(c=='T')
                    arr[i] |= bit;
                bit*=2;
            }
        }

        bt(0);
        System.out.println(ret);

    }

    // 정수로 변환하는 함수
    static int stoi(String str){
        return Integer.parseInt(str);
    }
}