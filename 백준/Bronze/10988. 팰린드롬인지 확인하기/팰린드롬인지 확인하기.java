import java.io.*;

public class Main {

    public static int soultion(String str) {
        int size = str.length();
        int ind = size-1;
        for(int i=0; i<size/2; i++){
            if (str.charAt(i)!=str.charAt(ind-i))
                return 0;
        }
        return 1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(soultion(str));
    }
}