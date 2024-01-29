import java.util.*;
import java.io.*;

public class Main {
    static int n, building[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        building = new int[1024];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ind = 0;
        while(st.hasMoreTokens()){
            building[ind++] = Integer.parseInt(st.nextToken());
        }
        Queue<int[]> q = new LinkedList<>();
        ind--;
        q.add(new int[]{0, ind});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                int start, end, mid;
                start = cur[0];
                end = cur[1];
                mid = (start+end)/2;
                System.out.print(building[mid]+" ");

                if(start<=(mid-1))
                    q.add(new int[]{start, mid-1});
                if((mid+1)<=end)
                    q.add(new int[]{mid+1,end});
            }
            System.out.println();
        }

    }
}