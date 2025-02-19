from collections import deque
import heapq

N,M = map(int,input().split())

start = int(input())

links = [[] for _ in range(N+1)]
dist = [ 1e9 for _ in range(N+1) ]

# 1,000,000,000

for _ in range(M):
    A,B,C = map(int,input().split())
    links[A].append([B,C])

# bfs!

q = []
heapq.heappush(q,[0,start])
dist[start] = 0

while q: # q 배열에 아무것도 없으면 False가 됩니다.

    # dist를 보고 순서를 바꾸는 코드!

    _w,node = heapq.heappop(q)
    
    for nxt, weight in links[node]:
        # 1. 각각의 노드에 값을 업데이트
        # 2. 만약에 여러 경로가 있다면 min 비교!
        # 3. 시작점으로부터 거리를 봐서, 짧은 순서대로 탐색! ( 오염 ! )
        if dist[node] + weight < dist[nxt]:
            dist[nxt] = dist[node] + weight
            heapq.heappush(q,[dist[nxt],nxt])

         
for j in range(1,N+1):
    if dist[j] == 1e9:
        print("INF")
    else:
        print(dist[j])
