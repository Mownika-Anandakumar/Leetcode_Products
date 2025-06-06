import java.io.*;
import java.util.*;

public class RedLightGreenLight {
    public static void main(String[] args) throws IOException {
        // Efficient input reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        
        // Read number of test cases
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            // Read N and K
            String[] nk = br.readLine().split(" ");
            int N = Integer.parseInt(nk[0]);
            int K = Integer.parseInt(nk[1]);
            
            // Read heights
            String[] heightsStr = br.readLine().split(" ");
            int count = 0;
            for (int i = 0; i < N; i++) {
                int h = Integer.parseInt(heightsStr[i]);
                if (h > K) {
                    count++;
                }
            }
            output.append(count).append("\n");
        }
        
        // Print all outputs at once
        System.out.print(output);
    }
}
