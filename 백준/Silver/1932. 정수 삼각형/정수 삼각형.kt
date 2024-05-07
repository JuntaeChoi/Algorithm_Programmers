import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tree = Array(n){ intArrayOf() }

    for(i in 0 until n){
        val nums = readLine().split(" ").map { it.toInt() }.toIntArray()
        tree[i]=nums
    }
    for(i in n-2 downTo 0){
        for(j in 0 until i+1){
            tree[i][j]+=Integer.max(tree[i+1][j],tree[i+1][j+1])
        }
    }
    println(tree[0][0])
}