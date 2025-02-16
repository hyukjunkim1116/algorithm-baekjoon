import sys
sys.setrecursionlimit(99999999)
def recur(y,x):

  if y == Y-1 and x == X-1:
    return 1

  if dp[y][x] != -1: # 모든 지점에서 계산이 한번이라도 된다면, 재사용!
    return dp[y][x]

  route = 0
  for dy, dx in [[1,0],[-1,0],[0,1],[0,-1]]:
    ey = y + dy
    ex = x + dx

    if 0 <= ey < Y and 0 <= ex < X:
      if graph[y][x] > graph[ey][ex]:
        route += recur(ey,ex)

  dp[y][x] = route

  return dp[y][x]



Y , X  = map(int,input().split())

graph = [list(map(int,input().split())) for _ in range(Y)]
dp = [[-1 for _ in range(X)] for _ in range(Y)]

answer = recur(0,0)

print(answer)
