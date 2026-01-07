from itertools import permutations

def solution(k, dungeons):
    answer = 0
    
    for perm in permutations(dungeons):
        fatigue = k
        count = 0
        
        for min_req, cost in perm:
            if fatigue >= min_req:
                fatigue -= cost
                count += 1
        
        answer = max(answer, count)
    
    return answer