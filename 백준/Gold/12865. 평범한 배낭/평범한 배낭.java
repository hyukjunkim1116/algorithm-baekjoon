
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int[][] dp;
    private static int n;
    private static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        dp = new int[n][100010];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 100010; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = recur(0,0);
        System.out.println(ans);
    }

    public static int recur(int cur, int w) {
        if (w > m) return Integer.MIN_VALUE;
        if (cur == n) return 0;
        if (dp[cur][w] != -1) return dp[cur][w];

        dp[cur][w] = Math.max(recur(cur+1,w+arr[cur][0])+arr[cur][1],recur(cur+1,w));

        return dp[cur][w];
    }
}