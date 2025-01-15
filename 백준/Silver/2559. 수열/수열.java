
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    List<Long> inputList = new ArrayList<>();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < A; i++) {
      inputList.add(Long.parseLong(st.nextToken()));
    }

    long answer = Long.MIN_VALUE;

    List<Long> prefix = new ArrayList<>();
    for (int i = 0; i < A + 1; i++) {
      prefix.add(0L);
    }

    for (int i = 0; i < inputList.size(); i++) {
      prefix.set(i + 1, prefix.get(i) + inputList.get(i));
    }

    for (int j = (int) B; j < prefix.size(); j++) {
      long tmp = prefix.get(j) - prefix.get(j - (int) B);
      if (tmp > answer) {
        answer = tmp;
      }
    }
    System.out.println(answer);
  }
}
