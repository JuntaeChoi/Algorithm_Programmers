import java.util.LinkedList

lateinit var arr : Array<Array<IntArray>>

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var line = readLine().split(" ")
    val x=line[0].toInt()
    val y=line[1].toInt()
    val z=line[2].toInt()
    arr=Array(z){Array(y){IntArray(x){0}}}
    for(i in 0 until z){
        for(j in 0 until y){
            val nums = readLine().split(" ").map { it.toInt() }.toIntArray()
            arr[i][j]=nums
        }
    }
    for(i in 0 until z){
        for(j in 0 until y){
            for(k in 0 until x){
                if(arr[i][j][k]==1)
                    BFS(k,j,i,x,y,z)
            }
        }
    }
    var max=0
    var hasZero = false
    for(i in 0 until z){
        for(j in 0 until y){
            for(k in 0 until x){
                if(arr[i][j][k]==0)
                    hasZero=true
                else{
                    max = Integer.max(max,arr[i][j][k])
                }
            }
        }
    }
    if(hasZero)
        println("-1")
    else
        println(max-1)
}
fun BFS(x:Int,y:Int,z:Int,mx:Int,my:Int,mz:Int){
    val dx = intArrayOf(1,-1,0,0,0,0)
    val dy = intArrayOf(0,0,1,-1,0,0)
    val dz = intArrayOf(0,0,0,0,1,-1)
    val queue = LinkedList<List<Int>>()
    queue.add(listOf(x,y,z,2))
    while(queue.isNotEmpty()){
        val (cx,cy,cz,count)=queue.poll()
        for(i in 0 until 6){
            val nx = cx+dx[i]
            val ny = cy+dy[i]
            val nz = cz+dz[i]
            if(nx in 0 until mx&&ny in 0 until my&&nz in 0 until mz&&arr[nz][ny][nx]!=-1&&(arr[nz][ny][nx]==0||arr[nz][ny][nx]>count)){
                arr[nz][ny][nx]=count
                queue.add(listOf( nx,ny,nz,count+1))
            }
        }
    }
}