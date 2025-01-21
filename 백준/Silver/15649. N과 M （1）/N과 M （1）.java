
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  private static int N;
  private static int M;
  private static List<Integer> arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new ArrayList<>();
    recur(0);
  }

  private static void recur(int number) {
    if (number == M) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < arr.size(); i++) {
        sb.append(arr.get(i));
        if (i != arr.size() - 1) {
          sb.append(" ");
        }
      }
      System.out.println(sb);
    }
    for (int i = 1; i < N + 1; i++) {
      if (arr.contains(i)) continue;

      arr.add(i);
      recur(number + 1);
      arr.remove(arr.size() - 1);
    }
  }
}
