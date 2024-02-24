def solution(elements):
    answer = 0
    a={}
    for i in range(len(elements)):
        temp=elements[i]
        a[temp]=1
        for j in range(1,len(elements)):
            temp+=elements[(i+j)%len(elements)]
            a[temp]=1
    return len(a)