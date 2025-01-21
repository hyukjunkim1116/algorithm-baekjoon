def recur(start, depth):
  if depth == M:  # 수열의 길이가 M이 되면
    print(*arr)  # 현재 수열 출력
    return

  for i in range(start, N + 1):  # start부터 N까지 순회
    arr.append(i)  # 현재 숫자 추가
    recur(i, depth + 1)  # 다음 숫자는 현재보다 큰 수부터 시작
    arr.pop()  # 백트래킹

N, M = map(int, input().split())
arr = []
recur(1, 0)