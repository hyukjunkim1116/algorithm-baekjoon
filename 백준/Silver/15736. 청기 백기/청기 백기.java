
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(
        (int)
            Math.sqrt(
                Integer.parseInt(
                        new BufferedReader(
                                new InputStreamReader(System.in))
                                .readLine())));
  }
}
