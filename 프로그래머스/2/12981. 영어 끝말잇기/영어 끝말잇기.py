def solution(n, words):
    used_words = set()
    
    for i, word in enumerate(words):
        # 탈락 조건 1: 이미 사용한 단어
        # 탈락 조건 2: 앞 단어의 마지막 글자로 시작하지 않는 경우
        if word in used_words or (i > 0 and words[i - 1][-1] != word[0]):
            person = (i % n) + 1  # 탈락한 사람 번호
            turn = (i // n) + 1   # 그 사람의 몇 번째 차례
            return [person, turn]
        
        used_words.add(word)
    
    return [0, 0]