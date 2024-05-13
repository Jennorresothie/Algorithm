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
        st = end = Integer.MIN_VALUE;
        for(Node node : nodes) {
            if(end<node.st) {
                ret += end - st;
                st = node.st;
                end = node.end;
            }
            else if(end< node.end)
                end = node.end;
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