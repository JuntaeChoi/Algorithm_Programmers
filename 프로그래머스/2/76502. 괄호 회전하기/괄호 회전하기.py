def solution(s):
    answer=0
    for i in range(len(s)-1):
        answer+=check(s)
        s = s[1:] + s[:1]
    return answer

def check(s):
    a=[]
    for i in s:
        if len(a)==0:
            a.append(i)
        elif i == "]" and a[-1]=="[":
            a.pop()
        elif i == "}" and a[-1]=="{":
            a.pop()
        elif i == ")" and a[-1]=="(":
            a.pop()
        else:
            a.append(i)
    return 1 if len(a)==0 else 0
        
    