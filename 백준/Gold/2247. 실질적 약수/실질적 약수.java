
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());

    long tmpA = 0;
    for (int i = 2; i < N / 2 + 1; i++) {
      tmpA += (long) (i * (Math.floor((double) N / i) - 1) % 1_000_000);
    }
    System.out.println(tmpA%1_000_000);
  }
}
