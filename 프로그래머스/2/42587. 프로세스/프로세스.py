def solution(priorities, location):
    queue = [(i,p) for i,p in enumerate(priorities)]
    answer = 0
    while True:
        now=queue.pop(0)
        if any(now[1]<q[1] for q in queue):
            queue.append(now)
        else:
            answer+=1
            if now[0]==location:
                return answer