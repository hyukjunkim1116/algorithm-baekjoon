
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] graph = new int[N][N];
    for (int i = 0; i < N; i++) {
      int[] list = new int[N];
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        list[j] = Integer.parseInt(st.nextToken());
      }
      graph[i] = list;
    }

    int[][] prefix = new int[N + 1][N + 1];

    for (int i = 0; i < N + 1; i++) {
      int[] list = new int[N + 1];
      for (int j = 0; j < N + 1; j++) {

        list[j] = 0;
      }
      prefix[i] = list;
    }

    for (int y = 0; y < N; y++) {
      for (int x = 0; x < N; x++) {
        prefix[y + 1][x + 1] = prefix[y][x + 1] + prefix[y + 1][x] - prefix[y][x] + graph[y][x];
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      int answer =
          prefix[y2][x2] - prefix[y2][x1 - 1] - prefix[y1 - 1][x2] + prefix[y1 - 1][x1 - 1];
      System.out.println(answer);
    }
  }
}
