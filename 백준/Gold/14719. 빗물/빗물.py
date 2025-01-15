H, W = map(int, input().split())
height_list = list(map(int, input().split()))
answer = 0

for i in range(1, W-1):  # 첫번째와 마지막 블록은 물이 고일 수 없음
  left_max = max(height_list[:i])  # 현재 위치의 왼쪽에서 가장 높은 블록
  right_max = max(height_list[i+1:])  # 현재 위치의 오른쪽에서 가장 높은 블록

  # 현재 위치에 고일 수 있는 물의 높이는 left_max와 right_max 중 작은 값에서 현재 높이를 뺀 값
  water = min(left_max, right_max) - height_list[i]
  if water > 0:
    answer += water

print(answer)
