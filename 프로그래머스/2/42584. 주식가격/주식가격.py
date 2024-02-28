from collections import deque
def solution(prices):
    answer=[]
    queue=deque(prices)
    
    while queue:
        now = queue.popleft()
        temp=0
        for i in queue:
            temp+=1
            if i < now:
                break
        answer.append(temp)
    return answer