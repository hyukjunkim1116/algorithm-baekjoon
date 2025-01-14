N = int(input())
answer = []
def _prime_factorization(number):
  # 2로 나누어지는 경우를 모두 처리
  while number % 2 == 0:
    answer.append(2)
    number //=2

  # 3부터 홀수 판단
  for i in range(3, int(number**0.5)+1,2):
    while number%i == 0:
      answer.append(i)
      number //= i

  # 마지막 남은 넘버가 2보다 크면 그대로 추가
  if number > 2:
    answer.append(number)

_prime_factorization(N)
print(len(answer))
print(' '.join(map(str, answer)))
