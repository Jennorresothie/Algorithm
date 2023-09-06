import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int DWAF = 9;
    static int[] arr = new int[DWAF];
    static boolean[] visit = new boolean[DWAF];
    static int[] temp = new int[7];
    static int[] answer = new int[7];

    public static void solution() {
        backtracking(0,0);
    }

    public static void backtracking(int depth, int sum) {
        //탈출조건 깊이가 7이상이거나 합이 100 이상일때
        if(depth>=7){
            if(depth==7&&sum==100){
                //answer 값 복사
                answer = Arrays.copyOf(temp, 7);
            }
            return;
        }

        for(int i=0;i<DWAF;i++){
            if(visit[i]) continue;
            if((sum+arr[i])<=100){
                visit[i]=true;
                temp[depth]=arr[i];
                backtracking(depth+1, sum+arr[i]);
                temp[depth]=0;
                visit[i]=false;
            }
        }

        return;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<DWAF;i++){
            arr[i]=sc.nextInt();
        }

        solution();

        Arrays.sort(answer);

        for(int i : answer)
            System.out.println(i);

    }
}