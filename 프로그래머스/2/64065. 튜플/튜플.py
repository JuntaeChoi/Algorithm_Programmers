def solution(s):
    s=s[2:-2]
    a=s.split("},{")
    a.sort(key=len)
    answer = []
    for i in a:
        temp = i.split(",")
        for j in temp:
            if not int(j) in answer:
                answer.append(int(j))
    return answer