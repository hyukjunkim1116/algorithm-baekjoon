N = int(input())
hint_list = [list(map(int,(input().split()))) for _ in range(N)]
# 123 1 1
# 356 1 0
# 327 2 0
# 489 0 1
answer = 0

for a in range(1,10):
  for b in range(1,10):
    for c in range(1,10):
      if a != b and b != c and c != a:
        count = 0
        for hint in hint_list:
          strike_count = 0
          ball_count = 0
          hint_input = hint[0] #123
          hint_100 = hint_input // 100  # 100의 자리수
          hint_10 = (hint_input % 100) // 10  # 10의 자리수
          hint_1 = (hint_input % 10) // 1 # 1의 자리수
          if (a == hint_100):
            strike_count+=1
          if (b == hint_10):
            strike_count+=1
          if (c== hint_1):
            strike_count+=1
          if (a == hint_10 or a== hint_1):
            ball_count+=1
          if b == hint_100 or b == hint_1:
            ball_count+=1
          if c== hint_100 or c == hint_10:
            ball_count+=1
          if strike_count == hint[1] and ball_count == hint[2]:
            count+=1
        if count == N:
          answer +=1
          count = 0
print(answer)