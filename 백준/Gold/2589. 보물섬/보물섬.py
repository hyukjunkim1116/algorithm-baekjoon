import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(input().rstrip()) for _ in range(n)]

# 육지 개수 확인 - 1개 이하면 바로 종료
land_count = sum(row.count('L') for row in graph)
if land_count <= 1:
  print(0)
  exit()

# 방향 배열 미리 선언
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(start_y, start_x):
  visited = set([(start_y, start_x)])
  dist = [[0] * m for _ in range(n)]
  q = deque([(start_y, start_x)])
  max_dist = 0

  while q:
    ey, ex = q.popleft()
    for i in range(4):
      ny, nx = ey + dy[i], ex + dx[i]
      if 0 <= ny < n and 0 <= nx < m and graph[ny][nx] == 'L' and (ny, nx) not in visited:
        visited.add((ny, nx))
        dist[ny][nx] = dist[ey][ex] + 1
        max_dist = max(max_dist, dist[ny][nx])
        q.append((ny, nx))

  return max_dist

maxi = 0
for y in range(n):
  for x in range(m):
    if graph[y][x] == 'L':
      maxi = max(maxi, bfs(y, x))

print(maxi)
