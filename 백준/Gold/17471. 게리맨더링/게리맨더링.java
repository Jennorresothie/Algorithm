import java.io.*;
import java.util.*;

public class Main {
    static final int INF=1000000;
    static int n, val[], link[], total, ret=INF;
    static boolean union[], visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = stoi(br.readLine());
        val = new int[n+1];
        link = new int[n+1];
        union = new boolean[n+1];
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){ // 인구수 저장
            val[i]=stoi(st.nextToken());
            total+=val[i];
        }
        for(int i=1; i<=n; i++){ // 각 도시에 연결된 도시를 이진수 위치로 표현
            st = new StringTokenizer(br.readLine());
            int temp = stoi(st.nextToken());
            for(int j=0; j<temp; j++){
                link[i] |= (1<<(stoi(st.nextToken())-1)); // 해당 위치 도시 비트 키기
            }
        }

        // 모든 가능성 확인
        for(int i=1; i<(1<<n)-1; i++){
            // 초기화
            Arrays.fill(union,false);
            Arrays.fill(visited, false);

            int s1=0,s2=0;

            for(int j=0; j<n; j++){
                if((i&(1<<j))>0) {
                    // 연합할 도시들
                    union[j+1]=true;
                    s1=j+1;
                }
                else
                    s2=j+1;
            }

            int S1[] = dfs(s1);
            int S2[] = dfs(s2);

            // 연합이 2개인지 확인
            if(S1[0]+S2[0]==n){ 
                int diff = Math.abs(S1[1]-S2[1]);
                ret = Math.min(ret, diff);
            }

        }


        System.out.println(ret==INF?-1:ret);

    }

    static int[] dfs(int start){
        visited[start]=true;

        int[] ret = new int[]{1, val[start]};
        for(int i=0; i<n; i++){
            if((link[start]&(1<<i))>0){
                if(visited[i+1])
                    continue;
                if(union[start]!=union[i+1])
                    continue;
                int[] temp = dfs(i+1);
                ret[0] += temp[0];
                ret[1] += temp[1];
            }
        }

        return ret;
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}