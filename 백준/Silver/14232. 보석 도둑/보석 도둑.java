
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long weight = Long.parseLong(br.readLine());
    List<Long> answerList = new ArrayList<>();
    while (weight % 2 == 0) {
      answerList.add(2L);
      weight /= 2;
    }

    for (long i = 3; i < Math.sqrt(weight) + 1; i += 2) {
      while (weight % i == 0) {
        answerList.add(i);
        weight /= i;
      }
    }
    if (weight > 2) {
      answerList.add(weight);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(answerList.size()).append('\n');
    for (int i = 0; i < answerList.size(); i++) {
      sb.append(answerList.get(i));
      if (i != answerList.size() - 1) {
        sb.append(' ');
      }
    }
    System.out.println(sb);
  }
}
