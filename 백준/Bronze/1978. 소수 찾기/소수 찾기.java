
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int answer = 0;
    List<Integer> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    while (st.hasMoreTokens()) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < N; i++) {
      int cand = list.get(i);
      for (int j = 2; j < cand + 1; j++) {
        if (j == cand) {
          answer++;
          break;
        }
        if (cand % j == 0) {
          break;
        }
      }
    }
    System.out.println(answer);
  }
}
