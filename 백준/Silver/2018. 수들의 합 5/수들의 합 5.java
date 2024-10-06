import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target =Integer.parseInt(st.nextToken());

        int startIndex = 1;
        int finishIndex = 1;
        int count = 1;
        int sum = 1;
        while (finishIndex != target) {
            if (sum == target) {
                count++;
                finishIndex++;
                sum = sum + finishIndex;
            } else if (sum > target) {
                sum = sum - startIndex;
                startIndex++;
            } else {
                finishIndex++;
                sum = sum + finishIndex;
            }
        }
        System.out.println(count);
    }
}