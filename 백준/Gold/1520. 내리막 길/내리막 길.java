
import java.io.*;
import java.util.*;

public class Main {
  static int Y, X;
  static int[][] graph;
  static int[][] dp;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Y = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    graph = new int[Y][X];
    dp = new int[Y][X];

    // Initialize graph
    for(int i = 0; i < Y; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < X; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // Initialize dp with -1
    for(int i = 0; i < Y; i++) {
      Arrays.fill(dp[i], -1);
    }

    int answer = recur(0, 0);
    System.out.println(answer);
  }

  static int recur(int y, int x) {
    if(y == Y-1 && x == X-1) {
      return 1;
    }

    if(dp[y][x] != -1) {
      return dp[y][x];
    }

    int route = 0;
    for(int i = 0; i < 4; i++) {
      int ey = y + dy[i];
      int ex = x + dx[i];

      if(ey >= 0 && ey < Y && ex >= 0 && ex < X) {
        if(graph[y][x] > graph[ey][ex]) {
          route += recur(ey, ex);
        }
      }
    }

    return dp[y][x] = route;
  }
}