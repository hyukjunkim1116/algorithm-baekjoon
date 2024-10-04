import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        double score[] = new double[N];
        double avg, max = 0, sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(st.nextToken());

            if (score[i] >= max) {
                max = score[i];
            }
        }

        for (int i = 0; i < score.length; i++) {
            score[i] = (score[i]/max)*100;
            sum += score[i];
        }
        avg = sum / N;
        System.out.println(avg);
    }
}