import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;
public class Main {
    static int n, box[][] = new int[101][101], ret, dire[][] = {{0,1},{1,0},{0,-1},{-1,0}}, d, time[], ind;
    static char com[];
    static Deque<int[]> snake = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        for(int i=0; i<a; i++) {
            String[] strs = br.readLine().split(" ");
            int r = Integer.parseInt(strs[0]);
            int c = Integer.parseInt(strs[1]);
            box[--r][--c] = 1;
        }
        snake.add(new int[]{0,0});
        a = Integer.parseInt(br.readLine());
        time = new int[a+1];
        com = new char[a+1];
        for(int i=0; i<a; i++) {
            String[] strs = br.readLine().split(" ");
            time[i] = Integer.parseInt(strs[0]);
            com[i] = strs[1].charAt(0);
        }

        box[0][0] = -1;

        while(true){
            // 머리 꺼낸다
            int[] cur = snake.peek();
            int nx, ny;
            ny = cur[0] + dire[d][0];
            nx = cur[1] + dire[d][1];

            if(nx<0||ny<0||ny>=n||nx>=n||box[ny][nx]==-1) {
                bw.write(String.valueOf(++ret));
                bw.close();
                return;
            }

            //꼬리 확인
            int[] last = snake.getLast();

            if(box[ny][nx]==1){
                box[last[0]][last[1]] = -1;
            }
            else {
                box[last[0]][last[1]] = 0;
                snake.removeLast();
            }
            box[ny][nx] = -1;
            snake.push(new int[]{ny, nx});

            ret++;

            if(time[ind]==ret) {
                if(com[ind]=='L')d = (d+3)%4;
                else d = (d+1)%4;
                ind++;
            }

        }
    }
}