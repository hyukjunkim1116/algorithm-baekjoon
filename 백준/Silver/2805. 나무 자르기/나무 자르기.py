import sys
N, M = map(int, sys.stdin.readline().split())
forest = list(map(int, sys.stdin.readline().split()))
s = 0
e = max(forest)

while s <= e : # 교차되기 전까지!
  mid = (s+e)//2

  # 얼마나 나무를 채취했나요?
  wood = sum(tree - mid for tree in forest if tree > mid)

  # 업인가요? 다운인가요?

  if wood >= M : #최소를 만족했다!
    s = mid +1
  else:
    e = mid -1

print(e)
