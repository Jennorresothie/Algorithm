import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, l, ret, box[][], mirrorBox[][];
    // ✨ 한행씩 확인한다
    /* ✨ n-1 까지 확인하며 현재위치와 다음 위치의 값을 비교한다
        같은 값이 cnt를 증가시킨다 (만약 내리막이면 cnt = -l+1)
        끝까지 도착하면 ret 값을 올린다.
     */
    static void check(int[][] map){
        for(int i=0; i<n; i++){
            int cnt=1, j;
            for(j=0; j<n-1; j++){
                if(map[i][j]==map[i][j+1]) cnt++;
                // 오름
                else if(map[i][j]+1 == map[i][j+1] && cnt>=l) cnt=1;
                // 내림
                else if(map[i][j]-1 == map[i][j+1] && cnt>=0) cnt=-l+1;
                else
                    break;
            }
            /*
            완성된 길이라면 j = n-1까지 이동 되어 있어야한다
            cnt 경우는 총 3가지다
            1. 내리막일때 cnt = 0
            2. 쭉 같은 값일때 cnt>0
            3. 오르막 일때 cnt >= l (1 ≤ l ≤ N)
             */
            if(n-1==j&&cnt>=0)
                ret++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        l = stoi(st.nextToken());

        box = new int[n][n];
        mirrorBox = new int[n][n];
        // 입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                box[i][j]=stoi(st.nextToken());
                // 같은 함수를 적용하기 위해 대칭되는 배열을 하나 더 생성
                mirrorBox[j][i] = box[i][j];
            }
        }

        check(box); check(mirrorBox);
        System.out.println(ret);

    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}