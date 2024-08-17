import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        double temp = 1.0;
        double max = -1.0;
        for(int i=0; i<n; i++) {
            double ele = Double.parseDouble(br.readLine());
            temp *= ele;
            if(temp<ele)
                temp = ele;
            max = Math.max(temp, max);
        }

        bw.write(String.format("%.3f", max));
        bw.flush();
        bw.close();
    }
}