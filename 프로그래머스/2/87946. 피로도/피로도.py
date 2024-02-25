from itertools import permutations
def solution(k, dungeons):
    answer=0
    for p in permutations(dungeons,len(dungeons)):
        temp=k
        sub_answer=0
        for need,cost in p:
            if temp>=need:
                sub_answer+=1
                temp-=cost
        if answer<sub_answer:
            answer = sub_answer
    return answer

