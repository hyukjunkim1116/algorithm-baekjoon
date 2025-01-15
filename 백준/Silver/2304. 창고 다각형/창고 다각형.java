
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    List<Integer> graph = new ArrayList<>();
    for (int i = 0; i < 10001; i++) {
      graph.add(0);
    }
    List<Integer> xList = new ArrayList<>();
    List<Integer> yList = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph.set(x, y);
      xList.add(x);
      yList.add(y);
    }

    int maxHeight = 0;
    for (int i = 0; i < yList.size(); i++) {
      if (yList.get(i) > maxHeight) {
        maxHeight = yList.get(i);
      }
    }
    int maxWidth = 0;
    for (int i = 0; i < xList.size(); i++) {
      if (xList.get(i) > maxWidth) {
        maxWidth = xList.get(i);
      }
    }

    List<Integer> prefix = new ArrayList<>();
    List<Integer> suffix = new ArrayList<>();

    for (int i = 0; i < maxWidth + 2; i++) {
      prefix.add(0);
      suffix.add(0);
    }

    List<Integer> maxPoint = new ArrayList<>();

    int h = 0;

    for (int i = 1; i < maxWidth + 3; i++) {
      if (graph.get(i) == maxHeight) {
        maxPoint.add(i);
        break;
      }
      h = Math.max(h, graph.get(i));
      prefix.set(i, prefix.get(i - 1) + h);
    }

    h = 0;

    for (int i = maxWidth; i > 0; i--) {
      if (graph.get(i) == maxHeight) {
        maxPoint.add(i);
        break;
      }
      h = Math.max(h, graph.get(i));
      suffix.set(i, suffix.get(i + 1) + h);
    }
    int max_prefix = 0;
    for (int i = 0; i < prefix.size(); i++) {
      if (prefix.get(i) > max_prefix) {
        max_prefix = prefix.get(i);
      }
    }
    int max_suffix = 0;
    for (int i = 0; i < suffix.size(); i++) {
      if (suffix.get(i) > max_suffix) {
        max_suffix = suffix.get(i);
      }
    }
    int answer = max_prefix + max_suffix + maxHeight * (maxPoint.get(1) - maxPoint.get(0) + 1);
    System.out.println(answer);
  }
}
