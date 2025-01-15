A = int(input())

input_list = list(map(int,input().split())) # -1 -2 -3 -4 -5


prefix = [-1001]*(A+1)

for i in range(A):
  # i = 3
  prefix[i+1] = max(prefix[i]+input_list[i], input_list[i])

prefix= sorted(prefix)

print(max(prefix))