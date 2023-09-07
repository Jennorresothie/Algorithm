import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void soultion(String str) {
        int[] arr = new int[26];
        // 문자열을 읽어가면서 'a'를 뺀 인덱스를 올려준다
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        soultion(str);
    }
}