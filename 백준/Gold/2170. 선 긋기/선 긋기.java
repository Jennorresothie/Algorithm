import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, ret=0;
        List<Node> nodes = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.add(new Node(x, y));
        }
        Collections.sort(nodes);

        int st, end;
        st = nodes.get(0).st;
        end = nodes.get(0).end;
        for(int i=1; i<n; i++) {
            if(end<nodes.get(i).st) {
                ret += end - st;
                st = nodes.get(i).st;
                end = nodes.get(i).end;
            }
            else if(end<nodes.get(i).end)
                end = nodes.get(i).end;
        }
        ret += end - st;
        bw.write(String.valueOf(ret));
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int st;
        int end;

        public Node(int x, int y) {
            this.st = x;
            this.end = y;
        }

        @Override
        public int compareTo(Node n) {
            return this.st - n.st;
        }
    }
}