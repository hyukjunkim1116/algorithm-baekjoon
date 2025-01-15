N = int(input())

graph = [0] * 10001

x_list = []
y_list = []

for i in range(N):
  x, y = map(int, input().split())
  graph[x] = y
  x_list.append(x)
  y_list.append(y)
max_height = max(y_list)
max_width = max(x_list)
prefix = [0] * (max_width + 2)
suffix = [0] * (max_width + 2)
max_point = []
h = 0

for f in range(1, max_width + 3):
  if graph[f] == max_height:
    max_point.append(f)
    break
  h = max(h, graph[f])
  prefix[f] = prefix[f - 1] + h

h = 0
for b in range(max_width, 0, -1):
  if graph[b] == max_height:
    max_point.append(b)
    break
  h = max(h, graph[b])
  suffix[b] = suffix[b + 1] + h
answer = max(prefix) + max(suffix)
answer += (max_point[1] - max_point[0] + 1) * max_height
print(answer)
