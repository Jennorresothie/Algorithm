import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int cur=-1;

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer( br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                   cur++;
                   arr[cur]=num;

                    break;
                case "top":
                   System.out.println(cur<0?-1:arr[cur]);

                    break;
                case "size":
                    System.out.println(cur+1);

                    break;
                case "empty":
                    System.out.println(cur==-1?1:0);

                    break;
                case "pop":
                    if(cur!=-1){
                        System.out.println(arr[cur]);
                        cur--;
                    }
                    else{
                        System.out.println(cur);
                    }

                    break;
                default:
                    break;
            }
        }

    }
}