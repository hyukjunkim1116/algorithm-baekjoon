A,B = map(int,input().split())
input_list = list(map(int,input().split())) # 3 -2 -4 -9 0 3 7 13 8 -3
prefix = [0]*(A+1)
answer= -101*B
for i in range(len(input_list)):
  prefix[i+1] = prefix[i]+input_list[i]

for j in range(B, len(prefix)):
  # 2 - 0 / 3 - 1
  tmp = prefix[j]-prefix[j-B]
  if (tmp>answer):
    answer =tmp
print(answer)

