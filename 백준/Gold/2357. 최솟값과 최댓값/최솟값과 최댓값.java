import java.io.*;
import java.util.*;

public class Main {
    // 입력 배열과 최소값, 최대값을 저장할 세그먼트 트리 선언
    static int[] arr;
    static int[][] minTree, maxTree;
    
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // N(배열 크기)과 M(쿼리 개수) 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 입력 배열 초기화 (1-based indexing)
        arr = new int[N + 1];
        // 세그먼트 트리의 높이 계산
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        // 세그먼트 트리의 크기 계산
        int treeSize = (1 << (h + 1));
        
        // 최소값과 최대값을 저장할 세그먼트 트리 초기화
        minTree = new int[treeSize][2];  // [0]: 최솟값, [1]: 인덱스
        maxTree = new int[treeSize][2];  // [0]: 최댓값, [1]: 인덱스
        
        // N개의 수 입력 받기
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 최소값과 최대값 세그먼트 트리 생성
        initMin(1, 1, N);
        initMax(1, 1, N);
        
        // M개의 쿼리 처리
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 구간 [a,b]의 최소값과 최대값 찾기
            int min = findMin(1, 1, N, a, b)[0];
            int max = findMax(1, 1, N, a, b)[0];
            
            // 결과를 StringBuilder에 추가
            sb.append(min).append(" ").append(max).append("\n");
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
    
    // 최소값 세그먼트 트리 초기화 메서드
    static int[] initMin(int node, int start, int end) {
        // 리프 노드인 경우
        if(start == end) {
            minTree[node][0] = arr[start];  // 값 저장
            minTree[node][1] = start;       // 인덱스 저장
            return minTree[node];
        }
        
        // 중간 노드인 경우 자식 노드들의 결과를 이용
        int mid = (start + end) / 2;
        int[] leftResult = initMin(node * 2, start, mid);
        int[] rightResult = initMin(node * 2 + 1, mid + 1, end);
        
        // 왼쪽과 오른쪽 자식 중 더 작은 값을 선택
        if(leftResult[0] <= rightResult[0]) {
            minTree[node][0] = leftResult[0];
            minTree[node][1] = leftResult[1];
        } else {
            minTree[node][0] = rightResult[0];
            minTree[node][1] = rightResult[1];
        }
        
        return minTree[node];
    }
    
    // 최대값 세그먼트 트리 초기화 메서드
    static int[] initMax(int node, int start, int end) {
        // 리프 노드인 경우
        if(start == end) {
            maxTree[node][0] = arr[start];  // 값 저장
            maxTree[node][1] = start;       // 인덱스 저장
            return maxTree[node];
        }
        
        // 중간 노드인 경우 자식 노드들의 결과를 이용
        int mid = (start + end) / 2;
        int[] leftResult = initMax(node * 2, start, mid);
        int[] rightResult = initMax(node * 2 + 1, mid + 1, end);
        
        // 왼쪽과 오른쪽 자식 중 더 큰 값을 선택
        if(leftResult[0] >= rightResult[0]) {
            maxTree[node][0] = leftResult[0];
            maxTree[node][1] = leftResult[1];
        } else {
            maxTree[node][0] = rightResult[0];
            maxTree[node][1] = rightResult[1];
        }
        
        return maxTree[node];
    }
    
    // 구간의 최소값을 찾는 메서드
    static int[] findMin(int node, int start, int end, int left, int right) {
        // 범위를 벗어난 경우
        if(left > end || right < start) {
            return new int[]{Integer.MAX_VALUE, 0};
        }
        
        // 범위에 완전히 포함되는 경우
        if(left <= start && end <= right) {
            return minTree[node];
        }
        
        // 범위가 걸쳐있는 경우 양쪽 자식 노드를 확인
        int mid = (start + end) / 2;
        int[] leftResult = findMin(node * 2, start, mid, left, right);
        int[] rightResult = findMin(node * 2 + 1, mid + 1, end, left, right);
        
        // 더 작은 값을 반환
        if(leftResult[0] <= rightResult[0]) {
            return leftResult;
        } else {
            return rightResult;
        }
    }
    
    // 구간의 최대값을 찾는 메서드
    static int[] findMax(int node, int start, int end, int left, int right) {
        // 범위를 벗어난 경우
        if(left > end || right < start) {
            return new int[]{Integer.MIN_VALUE, 0};
        }
        
        // 범위에 완전히 포함되는 경우
        if(left <= start && end <= right) {
            return maxTree[node];
        }
        
        // 범위가 걸쳐있는 경우 양쪽 자식 노드를 확인
        int mid = (start + end) / 2;
        int[] leftResult = findMax(node * 2, start, mid, left, right);
        int[] rightResult = findMax(node * 2 + 1, mid + 1, end, left, right);
        
        // 더 큰 값을 반환
        if(leftResult[0] >= rightResult[0]) {
            return leftResult;
        } else {
            return rightResult;
        }
    }
}