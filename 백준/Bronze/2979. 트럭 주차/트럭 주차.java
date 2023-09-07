import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void solution(int[] price, int[][] truck){
        int[] cnt = new int[101];
        int sum = 0;

        for(int i=0;i<3;i++){
            for(int j = truck[i][0]+1; j<=truck[i][1]; j++){
                cnt[j]++;
            }
        }

        for(int i : cnt){
            if(i==0) continue;
            sum+=price[i-1]*i;
        }

        System.out.println(sum);

    }

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[st.countTokens()];
        int count = 0;
        while (st.hasMoreTokens()){
            price[count++] = Integer.parseInt(st.nextToken());
        }

        int [][] truck = new int[3][2];

        String[] truck1 = br.readLine().split(" ");
        String[] truck2 = br.readLine().split(" ");
        String[] truck3 = br.readLine().split(" ");

        for(int i=0;i<2;i++){
            truck[0][i]=Integer.parseInt(truck1[i]);
            truck[1][i]=Integer.parseInt(truck2[i]);
            truck[2][i]=Integer.parseInt(truck3[i]);
        }

        solution(price, truck);

    }
}