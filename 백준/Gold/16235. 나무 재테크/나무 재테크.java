import java.io.*;
import java.util.*;

public class Main {
    static int map[][], robot[][], dire[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        robot = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                robot[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        List<int[]> trees = new ArrayList<>();
        Queue<int[]> dead = new LinkedList<>();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            trees.add(new int[]{x-1, y-1, z});
        }

        for (int t=0; t<k; t++) {
            Collections.sort(trees, (o1, o2) -> o1[2]-o2[2]);

            Queue<int[]> temp = new LinkedList<>();

            for (int[] tree : trees)
                temp.add(tree);

            trees.clear();

            // 봄
            while(!temp.isEmpty()) {
                int[] tree = temp.poll();
                int x = tree[0];
                int y = tree[1];
                int age = tree[2];

                if(map[x][y]>=age) {
                    map[x][y]-=age;
                    trees.add(new int[]{x,y,age+1});
                    if((age+1)%5==0) {
                        for (int i=0; i<8; i++) {
                            int dy = y + dire[i][0];
                            int dx = x + dire[i][1];

                            if(dy<0||dy>=n||dx<0||dx>=n) continue;

                            trees.add(new int[]{dx, dy, 1});
                        }
                    }
                } else
                    dead.add(tree);
            }

            // 여름
            while (!dead.isEmpty()) {
                int[] tree = dead.poll();
                map[tree[0]][tree[1]] += tree[2] / 2;
            }

            // 겨울
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    map[i][j]+=robot[i][j];
                }
            }

        }

        bw.write(trees.size()+"");
        bw.flush();
        bw.close();
    }

}