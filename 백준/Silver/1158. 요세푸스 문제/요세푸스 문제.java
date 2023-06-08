import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++)
            q.add(i+1);

        bw.write('<');
        while(!q.isEmpty()){
            for(int i=0;i<k-1;i++){
                q.add(q.poll());
            }
            if(q.size()==1){
                bw.write(q.poll()+">");
                bw.flush();
                bw.close();
            }
            else{
                bw.write(q.poll()+", ");
            }

        }
    }

}