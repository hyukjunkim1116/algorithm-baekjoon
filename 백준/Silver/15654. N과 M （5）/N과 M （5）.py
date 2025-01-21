N,M = map(int,input().split())

arr = list(map(int,input().split()))
arr.sort()

tmp = []
def recur(number):
  if number == M:
    print(*tmp)
    return
  for i in range(0,N):
    if arr[i] in tmp:
      continue
    tmp.append(arr[i])
    recur(number+1)
    tmp.pop()

recur(0)