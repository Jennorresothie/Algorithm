import java.util.*;
import java.io.*;
public class Main {
    static class Station {
        int gas, pos;

        Station(int pos, int gas) {
            this.gas = gas;
            this.pos = pos;
        }
    }
    static int n, target, gas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Station> stations = new PriorityQueue<>(((o1, o2) -> o1.pos- o2.pos));
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            stations.add(new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());
        int anwser = 0;

        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());
        while (gas<target) {
            while (!stations.isEmpty() && stations.peek().pos <= gas) {
                fuels.add(stations.poll().gas);
            }

            if (fuels.isEmpty()) {
                anwser = -1;
                break;
            }

            anwser++;
            gas += fuels.poll();
        }

        bw.write(String.valueOf(anwser));
        bw.flush();
        bw.close();
        br.close();
    }
}