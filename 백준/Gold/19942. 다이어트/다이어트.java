
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  private static int answerPrice = Integer.MAX_VALUE;
  private static int N;
  private static List<List<Integer>> answerList = new ArrayList<>();
  private static List<Integer> usedList = new ArrayList<>();
  private static int[][] ingre;
  private static int A;
  private static int B;
  private static int C;
  private static int D;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    ingre = new int[N][5];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      ingre[i][0] = Integer.parseInt(st.nextToken());
      ingre[i][1] = Integer.parseInt(st.nextToken());
      ingre[i][2] = Integer.parseInt(st.nextToken());
      ingre[i][3] = Integer.parseInt(st.nextToken());
      ingre[i][4] = Integer.parseInt(st.nextToken());
    }

    recur(0, 0, 0, 0, 0, 0);
    if (answerList.isEmpty()) {
      System.out.println(-1);
    } else {
      List<Integer> a = answerList.get(0);
      System.out.println(answerPrice);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < a.size(); i++) {
        sb.append(a.get(i));
        if (i < a.size() - 1) sb.append(" ");
      }
      System.out.println(sb);
    }
  }

  private static void recur(int idx, int a, int b, int c, int d, int price) {
    if (a >= A && b >= B && c >= C && d >= D) {
      if (price < answerPrice) {
        answerPrice = price;
        answerList.clear();
        answerList.add(new ArrayList<>(usedList));
      }
      if (price == answerPrice) {
        answerList.add(new ArrayList<>(usedList));
      }
    }
    if (idx == N) return;

    usedList.add(idx + 1);
    recur(
        idx + 1,
        a + ingre[idx][0],
        b + ingre[idx][1],
        c + ingre[idx][2],
        d + ingre[idx][3],
        price + ingre[idx][4]);
    usedList.remove(usedList.size() - 1);
    recur(idx + 1, a, b, c, d, price);
  }
}
