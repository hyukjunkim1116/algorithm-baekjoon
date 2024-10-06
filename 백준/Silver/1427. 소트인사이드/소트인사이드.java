import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //선택정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        selectionSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0 ; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

    private static void selectionSort(char[] arr) {
        int indexMin;
        char temp;
        for (int i = 0; i < arr.length; i++) {
            indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }

            temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
        }
    }
}
