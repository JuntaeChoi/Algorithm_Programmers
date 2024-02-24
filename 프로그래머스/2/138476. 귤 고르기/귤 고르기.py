def solution(k, tangerine):
    answer=0
    a={}
    for i in tangerine:
        if i in a:
            a[i]+=1
        else:
            a[i]=1
    count = sorted(a.items(),reverse=True,key=lambda x:x[1])
    
    for key,value in count:
        if k>0:
            k-=value
            answer+=1
    return answer