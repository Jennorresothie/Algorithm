import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int len, popul;

        Node (int len, int pop) {
            this.len = len;
            this.popul = pop;
        }
    }

    static int n, m, t, k, timeline[] = new int[301], dp[][];
    static ArrayList<Node> section = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        dp = new int[n+1][k+1];

        // 값을 입력받고 시간 순서대로 시간에 존재하는 사람들의 수를 기록한다
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s, e;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            for (int j=s; j<e; j++) {
                //if(j>n) break;
                // 기록하되, t이상 기록되지 않게 작업한다.
                timeline[j] = Math.min(t, timeline[j]+1);
            }
        }

        // 인원 수별로 각 구간을 나누어 준다.

        int people = timeline[1];
        int cnt = 1; // 구간의 개수
        for (int i=2; i<=n; i++) {
            if(people != timeline[i]) { // 인원의 변동이 생기면 구간이 달라진 것이다.
                section.add(new Node(cnt, people));
                cnt=0;
                people = timeline[i];
            }
            cnt++;
        }
        // 마지막 구간 입력
        section.add(new Node(cnt, people));

        bw.write(go(0,k,0)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    /*
        @ section_ind : 구간의 인덱스
        @ last : k의 남은 인원
        @ friend : 이전에 추가해 존재하는 인원
        @ cost : 부족한 인원
     */
    static int go(int section_ind, int last, int friend) {
        if (section_ind == section.size()) return 0;
        if (dp[section_ind][last] != 0) return dp[section_ind][last];

        int cost  = Math.max(0, t - section.get(section_ind).popul);
        int realCost = (friend>=cost) ? 0 : cost - friend; // 이미 투입된 친구수 만큼 제거

        if (last - realCost >= 0) {
            // cost로 넘기는 이유 : 부족한 수만큼 친구를 추가 했다는 것
            return dp[section_ind][last] = Math.max(go(section_ind+1, last-realCost, cost) + section.get(section_ind).len, go(section_ind+1, last, 0));
        }
        else return dp[section_ind][last] = go(section_ind+1, last, 0);

    }
}