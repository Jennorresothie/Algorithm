import java.io.*;
import java.util.*;
public class Main {
    static int n,m,k, map[][], ret;
    static Shark sharks[];

    static class Shark {
        boolean isLive;
        int r;
        int c;
        int speed;
        int direction;
        int size;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.speed = s;
            this.direction = d;
            this.size = z;
            this.isLive = true;
        }
    }
    static void solution() {
        for(int i=0; i<m; i++) {
            hook(i); // 상어 잡기
            move(); // 상어 이동
        }
    }
    static void hook(int i) {
        for(int j=0; j<n; j++) {
            if(map[j][i]!=0) {
                Shark s = sharks[map[j][i]-1];
                s.isLive = false;
                ret+=s.size;
                map[j][i]=0;
                return;
            }
        }
        return;
    }
    static void move() {
        int[][] temp = new int[n][m];

        for(int j=0; j<k; j++) {
            Shark s = sharks[j];
            if(s.isLive) {
                for(int i=0; i<s.speed; i++) {
                    if(s.direction==1) {
                        if(s.r==0) {
                            s.direction = 2;
                            i--;
                            continue;
                        }
                        s.r--;
                    }
                    else if(s.direction==2) {
                        if(s.r==n-1) {
                            s.direction = 1;
                            i--;
                            continue;
                        }
                        s.r++;
                    }
                    else if(s.direction==3) {
                        if(s.c==(m-1)) {
                            s.direction = 4;
                            i--;
                            continue;
                        }
                        s.c++;
                    }
                    else if(s.direction==4) {
                        if(s.c==0) {
                            s.direction = 3;
                            i--;
                            continue;
                        }
                        s.c--;
                    }
                }
                if(temp[s.r][s.c]!=0) {
                    if(sharks[temp[s.r][s.c]-1].size > s.size) {
                        s.isLive = false;
                        continue;
                    }
                    else{
                        sharks[temp[s.r][s.c]-1].isLive = false;
                    }
                }
                temp[s.r][s.c] = j+1;
            }
        }

        for(int i=0; i<n; i++) map[i] = Arrays.copyOf(temp[i],temp[i].length);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        k = stoi(st.nextToken());

        map = new int[n][m];
        sharks = new Shark[k];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int r, c, s, b, z;
            r = stoi(st.nextToken());
            c = stoi(st.nextToken());
            s = stoi(st.nextToken());
            b = stoi(st.nextToken());
            z = stoi(st.nextToken());
            --r;--c;
            sharks[i] = new Shark(r,c,s,b,z);
            map[r][c] = i+1;
        }

        solution();
        bw.write(String.valueOf(ret));
        bw.close();

    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}