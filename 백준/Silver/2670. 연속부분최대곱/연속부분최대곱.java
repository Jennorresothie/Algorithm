import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double arr[] = new double[n];
        double max = Double.MIN_VALUE;

        for(int i=0; i<n; i++)
            arr[i] = Double.parseDouble(br.readLine());

        for (int i=0; i<n; i++) {
            double temp = 1.0;
            for (int j=i; j<n; j++) {
                temp *= arr[j];
                max = Math.max(temp, max);
            }
        }

        bw.write(String.format("%.3f", max));
        bw.flush();
        bw.close();
    }
}