# 1. 갭을 줄여도 된다!
# 12 8
# 8 4

# 2. 최대 공약수라는 말은 두 수 중 하나로 나누어서 나머지가 생기지 않는다
# 8 4
# 최대공약수

# 3. 한 수를 가능한 만큼 갭을 줄인다
# 하나의 수를 작은수로 되는만큼 뺀다는 말은
# 나누고 나서의 나머지를 뜻한다.

def _gcd(a,b):
  while a % b != 0:
    tmp = a % b
    a = b
    b = tmp
  return b

def _lcm(a,b):
  return a*b//_gcd(a,b)

A, B = map(int, input().split())

divide = B // A
min_sum = 2000000000
answer = 0
# 두 수의 최대 공약수가 6이면 두 수 모두 6을 약수로 가지고 있다
# 최소 공배수는 서로소인 두 수의 곱과 최대공약수를 곱한 값이다

for i in range(1, int(divide**0.5)+1):
  j = int (divide/i)

  if divide % i == 0 and _gcd(i,j) == 1:
    if j-i < min_sum:
      min_sum = j - i
      answer = f"{i*A} {j*A}"

print(answer)

