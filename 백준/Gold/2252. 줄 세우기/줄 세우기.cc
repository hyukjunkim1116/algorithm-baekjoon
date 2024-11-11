#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, M; // N: 학생 수, M: 키 비교 횟수
vector<vector<int>> graph; // 인접 리스트로 구현한 그래프
vector<int> inDegree; // 진입차수 저장 배열

void topologicalSort() {
    queue<int> q;
    
    // 진입차수가 0인 노드를 큐에 삽입
    for(int i = 1; i <= N; i++) {
        if(inDegree[i] == 0) {
            q.push(i);
        }
    }
    
    // 큐가 빌 때까지 반복
    while(!q.empty()) {
        int cur = q.front();
        q.pop();
        
        cout << cur << " "; // 현재 노드 출력
        
        // 현재 노드와 연결된 모든 노드들의 진입차수를 1 감소
        for(int next : graph[cur]) {
            inDegree[next]--;
            // 진입차수가 0이 된 노드를 큐에 삽입
            if(inDegree[next] == 0) {
                q.push(next);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    // 입력 받기
    cin >> N >> M;
    
    // 그래프와 진입차수 배열 초기화
    graph.resize(N + 1);
    inDegree.resize(N + 1, 0);
    
    // 키 비교 정보 입력
    for(int i = 0; i < M; i++) {
        int A, B;
        cin >> A >> B;
        graph[A].push_back(B); // A -> B 방향 간선 추가
        inDegree[B]++; // B의 진입차수 증가
    }
    
    // 위상정렬 수행
    topologicalSort();
    
    return 0;
}