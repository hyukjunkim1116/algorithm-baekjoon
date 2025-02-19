import sys
input = sys.stdin.readline

n = int(input())
arr1 = sorted(list(map(int,input().split())))
m = int(input())
arr2 = list(map(int,input().split()))

for number in arr2:

  s = 0
  e = n-1
  check = False
  while s <= e :
    mid = (s + e)//2
    if arr1[mid] == number:
      check = True
      break
    elif arr1[mid] > number:
      e = mid - 1
    else:
      s = mid + 1

  if check:
    print(1, end=" ")
  else:
    print(0, end=" ")
