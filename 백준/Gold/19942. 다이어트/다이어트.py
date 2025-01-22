N = int(input())

A, B, C, D = map(int, input().split())

ingre = [list(map(int, input().split())) for _ in range(N)]

answer_price = 999999999999
answer_list = []
used_list = []

def recur(idx, a, b, c,d,price):
  global answer_price, used_list, answer_list
  if a>=A and b>=B and c>=C and d>=D:
    if price < answer_price:
      answer_price = price
      answer_list = [used_list[:]]
    if price == answer_price:
      answer_price = price
      answer_list.append(used_list[:])
  if idx == N:
    return
  used_list.append(idx+1)
  recur(idx + 1, a+ingre[idx][0],b+ingre[idx][1],c+ingre[idx][2],d+ingre[idx][3],price+ingre[idx][4])
  used_list.pop()
  recur(idx + 1, a, b, c,d,price)


recur(0, 0, 0, 0,0,0)
answer = [999999999999]
if answer_list:
  for i in answer_list:
    if i < answer:
      answer = i
  print(answer_price)
  print(*answer)
else:
  print(-1)
