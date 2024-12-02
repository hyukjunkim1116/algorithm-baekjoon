import java.io.*;
import java.util.*;

public class Main {
    // 트리를 표현할 이차원 배열
    static int[][] tree;
    static StringBuilder preorder = new StringBuilder();
    static StringBuilder inorder = new StringBuilder();
    static StringBuilder postorder = new StringBuilder();
        
   static void preorder(int node) {
        if(node == -1) return;
        preorder.append((char)(node + 'A'));  // 루트
        preorder(tree[node][0]);              // 왼쪽
        preorder(tree[node][1]);              // 오른쪽
    }

    static void inorder(int node) {
        if(node == -1) return;
        inorder(tree[node][0]);               // 왼쪽
        inorder.append((char)(node + 'A'));   // 루트
        inorder(tree[node][1]);               // 오른쪽
    }

    static void postorder(int node) {
        if(node == -1) return;
        postorder(tree[node][0]);             // 왼쪽
        postorder(tree[node][1]);             // 오른쪽
        postorder.append((char)(node + 'A')); // 루트
    } 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 트리 배열 초기화 (0: 왼쪽 자식, 1: 오른쪽 자식)
        tree = new int[26][2];  // A-Z를 0-25로 표현
        
        // 트리 구성
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int parent = input[0].charAt(0) - 'A';  // 문자를 인덱스로 변환
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            
            // 왼쪽 자식 설정
            tree[parent][0] = left == '.' ? -1 : left - 'A';
            // 오른쪽 자식 설정
            tree[parent][1] = right == '.' ? -1 : right - 'A';
        }
        
        // 순회 시작 (루트 노드 A는 인덱스 0)
        preorder(0);
        inorder(0);
        postorder(0);
        
        // 결과 출력
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }
}