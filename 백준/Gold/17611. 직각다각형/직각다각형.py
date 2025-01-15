N = int(input())

arr = []
arr_x = []
arr_y = []
for i in range(N):
    x, y = map(int, input().split())
    arr.append([x, y])
    arr_x.append(x)
    arr_y.append(y)

# 마지막 점과 첫 점 연결
arr_x.append(arr_x[0])
arr_y.append(arr_y[0])

def get_max(array, minimum, diff):
    graph = [0] * (diff + 1)
    for i in range(N):
        if array[i] != array[i+1]:
            low = min(array[i], array[i+1]) - minimum
            high = max(array[i], array[i+1]) - minimum
            graph[low] += 1
            if high < diff + 1:
                graph[high] -= 1
    
    prefix = [0] * (diff + 1)
    prefix[0] = graph[0]
    for i in range(1, diff + 1):
        prefix[i] = prefix[i-1] + graph[i]
    
    return max(prefix)

max_y = max(arr_y)
min_y = min(arr_y)
diff_y = max_y - min_y

max_x = max(arr_x)
min_x = min(arr_x)
diff_x = max_x - min_x

h = get_max(arr_y, min_y, diff_y)
v = get_max(arr_x, min_x, diff_x)
print(max(h, v))