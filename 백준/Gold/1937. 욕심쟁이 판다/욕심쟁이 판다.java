import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[][] graph;
  static int[][] dp;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    graph = new int[n][n];
    dp = new int[n][n];

    // Input graph
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // Visit all points
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        recur(y, x);
      }
    }

    // Find maximum value in dp
    int maxValue = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        maxValue = Math.max(maxValue, dp[i][j]);
      }
    }

    System.out.println(maxValue + 1);
  }

  static int recur(int y, int x) {
    if (dp[y][x] != 0) {
      return dp[y][x];
    }

    for (int i = 0; i < 4; i++) {
      int ey = y + dy[i];
      int ex = x + dx[i];

      if (ey >= 0 && ey < n && ex >= 0 && ex < n) {
        if (graph[y][x] < graph[ey][ex]) {
          dp[y][x] = Math.max(dp[y][x], recur(ey, ex) + 1);
        }
      }
    }

    return dp[y][x];
  }
}