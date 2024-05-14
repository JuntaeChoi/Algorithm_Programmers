import java.util.*



fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array1 = Array(n){CharArray(n)}
    val array2 = Array(n){CharArray(n)}
    for(i in 0 until n){
        val line = readLine().map { it }.toCharArray()
        for(j in 0 until n){
            array1[i][j]=line[j]
            if(line[j]=='G') array2[i][j]='R'
            else array2[i][j]=line[j]
        }
    }
    var count1 =0
    var count2 =0
    for(i in 0 until n){
        for(j in 0 until n){
            if(DFS(j,i,n,array1)) count1++
            if(DFS(j,i,n,array2)) count2++
        }
    }
    println("$count1 $count2")
}
fun DFS(x:Int,y:Int,n:Int,array:Array<CharArray>):Boolean{
    val xmove = intArrayOf(1,-1,0,0)
    val ymove = intArrayOf(0,0,1,-1)

    if(array[y][x]==' ')
        return false
    val color = array[y][x]
    array[y][x] =' '

    for(i in 0 until 4){
        if(x+xmove[i] !in 0 until n || y+ymove[i] !in 0 until n || array[y+ymove[i]][x+xmove[i]]!=color)
            continue
        DFS(x+xmove[i],y+ymove[i],n,array)
    }
    return true
}