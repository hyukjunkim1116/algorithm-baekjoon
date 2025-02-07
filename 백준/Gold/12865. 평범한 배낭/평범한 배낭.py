def recur(cur, w):
  global ans
  if w > m:
    return -9999999

  if cur == n:
    return 0

  if dp[cur][w] != -1:
    return dp[cur][w]

  dp[cur][w] = max(recur(cur+1, w + arr[cur][0]) + arr[cur][1], recur(cur + 1 , w))

  return dp[cur][w]

n, m = map(int,input().split())
arr = [list(map(int,input().split())) for i in range(n)]

dp = [[-1 for _ in range(100010)] for j in range(n)]

ans = recur(0,0)

print(ans)
