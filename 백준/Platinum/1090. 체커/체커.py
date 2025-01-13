N = int(input())
arr =[]
arr_x = []
arr_y = []
answer = [-1]*N
for _ in range(N):
  x,y = map(int,input().split())
  arr.append([x,y])
  arr_x.append(x)
  arr_y.append(y)
for x in arr_x:
  for y in arr_y:
    dist = []
    # 거리 계산
    for ex,ey in arr:
      d = abs(ex-x)+ abs(ey-y) # 거리
      dist.append(d)
      
    # 오름차순 정렬
    dist.sort()

    # 정답 배열과 비교
    tmp = 0
    for i in range(len(dist)):
      d = dist[i]
      tmp += d
      if answer[i] == -1:
        answer[i] = tmp
      else:
        answer[i] = min(answer[i],tmp)

print(*answer)