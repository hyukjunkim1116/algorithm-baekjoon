from collections import deque

computer = int(input())
connection = int(input())
graph = [[]for _ in range (computer+1)]
visited = [0 for _ in range (computer+1)]

for _ in range (connection):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    
q = deque()
q.append(1)
while q:
    k = q.popleft()
    visited[k] = 1
    for i in graph[k]:
        if visited[i] == 0:
            q.append(i)

print(sum(visited)-1)
