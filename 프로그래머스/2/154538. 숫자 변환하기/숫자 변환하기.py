def solution(x, y, n):
    s = set()
    s.add(x)
    answer=0
    while s:
        if y in s:
            return answer
        else:
            temp = set()
            answer+=1
            for i in s:
                if i+n<=y:
                    temp.add(i+n)
                if i*2<=y:
                    temp.add(i*2)
                if i*3<=y:
                    temp.add(i*3)
            s=temp
    return -1