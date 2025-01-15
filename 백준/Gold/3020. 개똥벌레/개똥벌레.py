import sys
input = sys.stdin.readline

N,H = map(int,input().split())

graph = [0 for _ in range(H+1)]

for i in range(N):
  h = int(input())
  if i % 2 == 0: #짝수, 종유석
    graph[-1] -=1
    graph[H-h] +=1
  else:
    graph[0] +=1
    graph[h] -=1

prefix = [0]*H

for j in range(H):
  if j==0: prefix[j] = graph[j]
  else: prefix[j] = prefix[j-1] + graph[j]

print(f"{min(prefix)} {prefix.count(min(prefix))}")
# print(graph)
# print(prefix)