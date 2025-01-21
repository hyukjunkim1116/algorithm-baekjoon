def recur(number):
  if number == M:
    print(*arr)
    return
  for j in range(1, N + 1):
    

    arr.append(j)
    recur(number + 1)
    arr.pop()

arr = []
N, M = map(int, input().split())

recur(0)