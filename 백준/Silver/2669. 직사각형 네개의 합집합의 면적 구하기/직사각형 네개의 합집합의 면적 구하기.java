import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] map = new boolean[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int area=0;

        for(int i=0;i<4;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j=x; j<x2; j++){
                for (int k=y; k<y2; k++){
                    if(!map[j][k]){
                        area++;
                        map[j][k]=true;
                    }
                }
            }
        }

        System.out.println(area);
    }
}