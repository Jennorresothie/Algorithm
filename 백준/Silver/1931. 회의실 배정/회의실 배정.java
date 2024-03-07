import java.io.*;
import java.util.*;

public class Main {
    static long ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[n];
        for(int i=0; i<n; i++) {
            String[] time = br.readLine().split(" ");
            rooms[i] = new Room(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
        }
        Arrays.sort(rooms);
        ret=1;
        int time = rooms[0].end;
        for(int i=1; i<n; i++) {
            if(time<=rooms[i].start){
                ret++;
                time = rooms[i].end;
            }
        }
        System.out.println(ret);
    }
}
class Room implements Comparable<Room> {
    int start, end;
    Room(int s, int e){
        this.start = s;
        this.end = e;
    }
    @Override
    public int compareTo(Room r) {
        if(this.end==r.end)
            return this.start - r.start;
        return this.end - r.end;
    }
    @Override
    public String toString() {
        return String.format("%d, %d",start, end);
    }
}