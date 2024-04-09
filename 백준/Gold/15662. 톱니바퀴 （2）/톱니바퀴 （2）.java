import java.io.*;
import java.util.*;
public class Main {
    static int n, arr[], ret;
    static boolean visited[];
    static Queue<int[]> q = new LinkedList<>();
    static void findL(int start, int rotate) {
        for(int pos = start; pos>0; pos--) {
            boolean flag = (arr[pos]&(1<<1))>0?true:false;
            boolean flag2 = (arr[pos-1]&(1<<5))>0?true:false;
            if(flag^flag2){
                rotate*=-1;
                q.add(new int[]{pos-1,rotate});
            }
            else return;
        }
    }
    static void findR(int start, int rotate) {
        for(int pos = start; pos<n-1; pos++) {
            boolean flag = (arr[pos]&(1<<5))>0?true:false;
            boolean flag2 = (arr[pos+1]&(1<<1))>0?true:false;
            if(flag^flag2){
                rotate*=-1;
                q.add(new int[]{pos+1,rotate});
            }
            else return;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine(),2);

        int k = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{--a, b});
        }

        for(int[] K: list) {
            q.add(new int[]{K[0], K[1]});
            findL(K[0], K[1]);
            findR(K[0], K[1]);
            while(!q.isEmpty()){
                int[] pos = q.poll();
                if(pos[1]==1) turn(pos[0]);
                else turn1(pos[0]);
            }
        }

        for(int i : arr) {
            if((i&1<<7)>0) ret++;
        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
    static void turn1(int n) { //시계반대
        int t = arr[n];
        t=t<<1;
        if((arr[n]&(1<<7))>1)
            t |= 1;

        t &= ~(1<<8);

        arr[n] = t;
    }

    static void turn(int n) { // 시계반향
        int t = arr[n];
        t=t>>1;
        if((arr[n]&1)>0)
            t |= (1<<7);

        arr[n] = t;
    }
}