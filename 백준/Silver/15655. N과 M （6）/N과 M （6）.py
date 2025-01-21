def recur(start, depth):
  if depth >= M:  # 수열의 길이가 M이 되면
    print(*tmp)  # 현재 수열 출력
    return

  for i in range(start, N):  # start부터 N까지 순회
    tmp.append(arr[i])  # 현재 숫자 추가
    recur(i+1, depth + 1)  # 다음 숫자는 현재보다 큰 수부터 시작
    tmp.pop()  # 백트래킹

N, M = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()

tmp = []
recur(0, 0)
#
# 1 7
# 1 8
# 1 9
# 7 8
# 7 9
# 8 9