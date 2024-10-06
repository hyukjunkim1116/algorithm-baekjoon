import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class SlidingWindow {
//    public static void main(String[] args) {
//        int n = 10; // N일 - 배열의 길이
//        int k = 3; // W 창문의 넓이
//        int[] arr = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15}; // 1차원 고정배열
//
//        System.out.println(solution(n, k, arr));
//    }
//
//    public static int solution(int n, int k, int[] arr) {
//        int result = 0; // 길이 k의 부분 수열의 요소 전체 합의 최댓값
//        int sum = 0; // 특정 부분 수열의 전체 합
//
//        // 배열의 가장 왼쪽부터 k까지의 값의 합을 sum에 담음
//        for (int i = 0; i < k; i++) {
//            sum += arr[i];
//        }
//
//        result = sum;
//
//        // k는 고정적이므로 새롭게 갱신되는 arr[i]와 기존 arr[i - k]를 빼줌
//        for (int i = k; i < arr.length; i++) {
//            sum += arr[i] - arr[i - k];
//            // 최대 합을 비교해서 갱신
//            result = Math.max(result, sum);
//        }
//
//        return result;
//    }
//}
public class Main {

    private static int sLen;
    private static int pLen;
    private static char[] str;
    private static int[] checkArr = new int[4];
    private static int[] myArr = new int[4];
    private static int checkCnt = 0;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sLen = Integer.parseInt(st.nextToken());
        pLen = Integer.parseInt(st.nextToken());
        str = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < pLen; i++) {
            if (str[i] == 'A') myArr[0]++;
            if (str[i] == 'C') myArr[1]++;
            if (str[i] == 'G') myArr[2]++;
            if (str[i] == 'T') myArr[3]++;
        }
        if (checkCounting()) {
            answer++;
        }

        int i = -1;

        for (int j = pLen; j < sLen; j++) {
            i = j - pLen;

            if (str[i] == 'A') myArr[0]--;
            if (str[i] == 'C') myArr[1]--;
            if (str[i] == 'G') myArr[2]--;
            if (str[i] == 'T') myArr[3]--;

            if (str[j] == 'A') myArr[0]++;
            if (str[j] == 'C') myArr[1]++;
            if (str[j] == 'G') myArr[2]++;
            if (str[j] == 'T') myArr[3]++;

            if (checkCounting()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean checkCounting() {
        for (int i = 0; i < 4; i++) {
            if (myArr[i] < checkArr[i]) {
                return false;
            }
        }
        return true;
    }
}