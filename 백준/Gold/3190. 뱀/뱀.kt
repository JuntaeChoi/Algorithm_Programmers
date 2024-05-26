import java.util.*


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val apples  = mutableSetOf<Pair<Int,Int>>()
    repeat(readLine().toInt()){
        val (y,x) = readLine().split(" ").map { it.toInt()-1 }
        apples.add(Pair(x,y))
    }
    val rotate = LinkedList<Pair<Int,Int>>()
    repeat(readLine().toInt()){
        val (time,direction) = readLine().split(" ")
        rotate.add(Pair(time.toInt(), if (direction == "D") 1 else 3))
    }
    val dx = intArrayOf(1,0,-1,0)
    val dy = intArrayOf(0,1,0,-1)
    val snake = LinkedList<Pair<Int,Int>>()
    snake.add(Pair(0,0))
    var time = 0
    var d = 0
    var nextRotate = rotate.poll()
    while(true){
        val (x,y) = snake.peekLast()
        if(nextRotate.first==time){
            d=(d+nextRotate.second)%4
            if(rotate.isNotEmpty())
                nextRotate=rotate.poll()
        }
        val nx = x+dx[d]
        val ny = y+dy[d]
        time+=1
        if(nx in 0 until n&&ny in 0 until n && !snake.contains(Pair(nx,ny))){
            if(apples.contains(Pair(nx,ny))){
                snake.add(Pair(nx,ny))
                apples.remove(Pair(nx,ny))
            }
            else{
                snake.add(Pair(nx,ny))
                snake.pollFirst()
            }
        }else{
            println(time)
            break
        }
    }
}