# 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
#
# 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
# 고른 수열은 오름차순이어야 한다.
def recur(start, depth):
  if depth == M:  # 수열의 길이가 M이 되면
    print(*arr)  # 현재 수열 출력
    return

  for i in range(start, N + 1):  # start부터 N까지 순회
    arr.append(i)  # 현재 숫자 추가
    recur(i + 1, depth + 1)  # 다음 숫자는 현재보다 큰 수부터 시작
    arr.pop()  # 백트래킹

N, M = map(int, input().split())
arr = []
recur(1, 0)