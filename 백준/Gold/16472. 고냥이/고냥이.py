import sys
input = sys.stdin.readline

n = int(input())
arr = list(input())
arr.pop()

#inch-worm

s = 0
e = 0
letters = []
letters.append(arr[s])

dist = 0

start_flag = -1

while s < len(arr) and e < len(arr):
  # print(s,e,letters)
  dist = max(dist, e-s+1)
  if len(letters) <= n:
    e += 1
    if e < len(arr) and arr[e] not in letters:
      letters.append(arr[e])
  if len(letters) > n :
    s = s+1
    e = s
    letters = [arr[s]]

print(dist)
