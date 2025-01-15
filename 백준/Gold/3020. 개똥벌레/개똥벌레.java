
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[] graph = new int[H + 1];

    for (int i = 0; i < N; i++) {
      int h = Integer.parseInt(br.readLine());
      if (i % 2 == 0) {
        graph[graph.length - 1] -= 1;
        graph[H - h] += 1;
      } else {
        graph[0] += 1;
        graph[h] -= 1;
      }
    }
    int[] prefix = new int[H];

    for (int j = 0; j < H; j++) {
      if (j == 0) prefix[j] = graph[j];
      else prefix[j] = graph[j] + prefix[j - 1];
    }


    int min = N;
    for (int j = 0; j < prefix.length; j++) {
      if (prefix[j] < min) {
        min = prefix[j];
      }
    }

    int count = 0;
    for (int j = 0; j < prefix.length; j++) {
      if (prefix[j] == min) {
        count++;
      }
    }

    System.out.printf("%d %d", min, count);
  }
}
