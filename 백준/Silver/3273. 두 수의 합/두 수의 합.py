import sys
input = sys.stdin.readline

n = int(input())
array = sorted(list(map(int, input().split())))
_sum = int(input())

s = 0
e = n-1
answer = 0

while s < e:
  if array[s] + array[e] > _sum:
    e -= 1
  if array[s] + array[e] == _sum:
    answer += 1
    e -= 1
  elif array[s] + array[e] < _sum:
    s += 1
  # print(s, e)

print(answer)
