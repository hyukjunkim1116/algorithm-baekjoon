import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] n = new int[6];
    for (int i = 0; i < 6; i++) {
      n[i] = Integer.parseInt(st.nextToken());
    }
    for (int x = -999; x <= 999; x++) {
      for (int y = -999; y <= 999; y++) {
        if (n[0] * x + n[1] * y == n[2]) {
          if (n[3] * x + n[4] * y == n[5]) {
            System.out.printf("%d %d", x, y);
          }
        }
      }
    }
  }
}