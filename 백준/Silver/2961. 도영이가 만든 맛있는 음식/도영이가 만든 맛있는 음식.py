N = int(input())

ingre = [list(map(int,input().split())) for _ in range(N)]

answer = 999999999999
def recur(idx, sour, bitter,used):
  global answer
  if idx == N:
    if used == 0:
      return
    answer = min(answer, abs(sour-bitter))
    return

  recur(idx+1, sour*ingre[idx][0], bitter+ingre[idx][1],used+1)
  recur(idx+1, sour, bitter,used)


recur(0,1,0,0)

print(answer)