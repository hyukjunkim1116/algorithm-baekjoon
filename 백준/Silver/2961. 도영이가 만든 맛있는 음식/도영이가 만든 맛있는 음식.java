
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static int answer = Integer.MAX_VALUE;
  private static int N;
    private static int[][] ingre;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    ingre = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      ingre[i][0] = Integer.parseInt(st.nextToken());
      ingre[i][1] = Integer.parseInt(st.nextToken());
    }
    recur(0, 1, 0, 0);
    System.out.println(answer);
  }

  private static void recur(int idx, int sour, int bitter, int used) {
      if (idx == N) {
          if (used == 0) {
              return;
          }
          answer = Math.min(answer, Math.abs(sour - bitter));
          return;
      }
      recur(idx + 1, sour * ingre[idx][0], bitter + ingre[idx][1], used + 1);
      recur(idx + 1, sour, bitter, used);
  }
}
