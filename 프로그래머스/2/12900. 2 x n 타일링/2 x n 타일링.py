def solution(n):
    answer=[]
    answer.append(0)
    answer.append(1)
    answer.append(2)
    if n==1:
        return 1
    elif n==2:
        return 2
    else:
        for i in range(3,n+1):
            answer.append((answer[i-1]+answer[i-2])%1000000007)
    return answer[n]
    