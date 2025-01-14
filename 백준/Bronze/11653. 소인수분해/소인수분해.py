N = int(input())
def _prime_factorization(number):
  for i in range(2, number+1):
    if number%i == 0:
      print(i)
      return _prime_factorization(number//i)
if N != 1:
  _prime_factorization(N)
