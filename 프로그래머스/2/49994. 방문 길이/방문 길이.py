def solution(dirs):
    di = list(dirs)
    now = [0,0]
    hash={}
    
    dxdy={
        "U":(0,1),
        "D":(0,-1),
        "L":(-1,0),
        "R":(1,0)
    }
    
    # 좌표값과 방향을 기록
    for d in di:
        dx,dy=dxdy[d]
        if -5<=now[0]+dx<=5 and -5<=now[1]+dy<=5:
            hash[now[0],now[1],now[0]+dx,now[1]+dy]=1
            hash[now[0]+dx,now[1]+dy,now[0],now[1]]=1         
            now[0]+=dx
            now[1]+=dy
    
    return len(hash)//2