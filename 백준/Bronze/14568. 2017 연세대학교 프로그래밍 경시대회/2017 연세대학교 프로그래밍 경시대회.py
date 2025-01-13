candy = int(input())

answer = 0

# 사탕을 줄 모든 경우의 수
for a in range(1, candy + 1):  # 택희
  for y in range(1, candy + 1):  # 영휸
    for n in range(1, candy + 1):  # 남규
      if a + y + n == candy:
        if y + 2 <= n:
          if a % 2 == 0:
            answer += 1
print(answer)