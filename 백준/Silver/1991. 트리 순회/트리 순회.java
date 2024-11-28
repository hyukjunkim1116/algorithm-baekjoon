import java.io.*;
import java.util.*;

public class Main {
    // 노드 클래스 정의
    static class Node {
        char value;     // 노드의 값
        Node left;      // 왼쪽 자식 노드
        Node right;     // 오른쪽 자식 노드
        
        Node(char value) {
            this.value = value;
        }
    }
    
    // 전위 순회 결과를 저장할 StringBuilder
    static StringBuilder preorder = new StringBuilder();
    // 중위 순회 결과를 저장할 StringBuilder 
    static StringBuilder inorder = new StringBuilder();
    // 후위 순회 결과를 저장할 StringBuilder
    static StringBuilder postorder = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 노드의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 노드들을 저장할 Map 생성 (key: 노드값, value: Node객체)
        Map<Character, Node> tree = new HashMap<>();
        
        // N개의 줄에 걸쳐 트리 정보 입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 현재 노드값과 왼쪽, 오른쪽 자식 노드값 입력
            char current = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            // 현재 노드가 Map에 없으면 새로 생성
            if(!tree.containsKey(current)) {
                tree.put(current, new Node(current));
            }
            
            // 왼쪽 자식이 있는 경우('.'이 아닌 경우)
            if(left != '.') {
                tree.put(left, new Node(left));
                tree.get(current).left = tree.get(left);
            }
            
            // 오른쪽 자식이 있는 경우('.'이 아닌 경우)
            if(right != '.') {
                tree.put(right, new Node(right));
                tree.get(current).right = tree.get(right);
            }
        }
        
        // 루트 노드(A)부터 시작하여 각각의 순회 실행
        traverse(tree.get('A'));
        
        // 결과 출력
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }
    
    // 트리 순회 메소드
    static void traverse(Node node) {
        if(node == null) return;
        
        // 전위 순회 처리 (루트 -> 왼쪽 -> 오른쪽)
        preorder.append(node.value);
        traverse(node.left);
        
        // 중위 순회 처리 (왼쪽 -> 루트 -> 오른쪽)
        inorder.append(node.value);
        traverse(node.right);
        
        // 후위 순회 처리 (왼쪽 -> 오른쪽 -> 루트)
        postorder.append(node.value);
    }
}