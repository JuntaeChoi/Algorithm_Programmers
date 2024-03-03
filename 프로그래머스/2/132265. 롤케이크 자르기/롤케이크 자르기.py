from collections import Counter
def solution(topping):
    answer = 0
    s1 = Counter(topping)
    s2 = set()
    if (len(s1)==len(s2)):
        answer+=1
    for i in topping:
        s1[i]-=1
        s2.add(i)
        if s1[i]==0:
            s1.pop(i)
        if (len(s1)==len(s2)):
            answer+=1
        if (len(s2)>len(s1)):
            break
    return answer