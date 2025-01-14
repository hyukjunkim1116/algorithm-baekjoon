A = int(input())

temp_A = 0

for i in range(2, int(A/2+1)):
    temp_A+= i*(A//i -1) % 1000000

print(temp_A % 1000000)