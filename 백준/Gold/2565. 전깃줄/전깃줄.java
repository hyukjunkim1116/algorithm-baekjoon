import java.io.*;
import java.util.*;

public class Main {
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int[][] pole = new int[n][2];
            int[] dp = new int[n];

            // Input and initialize dp array
            for(int i = 0; i < n; i++) {
                  StringTokenizer st = new StringTokenizer(br.readLine());
                  pole[i][0] = Integer.parseInt(st.nextToken());
                  pole[i][1] = Integer.parseInt(st.nextToken());
                  dp[i] = 1;
            }

            // Sort pole array based on first column
            Arrays.sort(pole, (a, b) -> a[0] - b[0]);

            // Find Longest Increasing Subsequence
            for(int i = 0; i < n; i++) {
                  for(int j = 0; j < i; j++) {
                        if(pole[i][1] > pole[j][1]) {
                              dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                  }
            }

            // Find maximum value in dp array
            int maxLength = 0;
            for(int i = 0; i < n; i++) {
                  maxLength = Math.max(maxLength, dp[i]);
            }

            // Print result
            System.out.println(n - maxLength);
      }
}