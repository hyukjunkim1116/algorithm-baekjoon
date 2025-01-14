N = int(input())
answer = 0
cand_list = list(map(int,input().split()))

for i in range(N):
  cand = cand_list[i]
  for j in range(2,cand+1):
    if j == cand:
      answer+=1
      break
    if cand % j == 0:
      break


print(answer)