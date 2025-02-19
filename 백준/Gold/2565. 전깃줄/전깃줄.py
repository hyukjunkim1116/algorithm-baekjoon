n = int(input())
pole =[ list(map(int,input().split())) for i in range(n)]

dp = [1 for _ in range(n)]
# 최장 수열을 구한 후 n에서 뺴면 정답
pole.sort()

for i in range(n):
  for j in range(i):
    if pole[i][1] > pole[j][1]:
      dp[i] = max(dp[i], dp[j] + 1)

print(n-max(dp))
