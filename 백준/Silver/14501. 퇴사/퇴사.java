
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  private static int answer = Integer.MIN_VALUE;
  private static int N;
  private static int[][]  inputList;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    inputList = new int[N][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      inputList[i][0] = Integer.parseInt(st.nextToken());
      inputList[i][1] = Integer.parseInt(st.nextToken());
    }
    recur(0, 0);
    System.out.println(answer);
  }

  private static void recur(int t, int p) {
    if (t > N-1) {
      if (t > N) {
        return;
      }
      answer = Math.max(answer, p);
      return;
    }
    recur(t + inputList[t][0], p+inputList[t][1]);
    recur(t + 1, p);
  }
}
