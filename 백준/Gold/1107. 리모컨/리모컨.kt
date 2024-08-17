import kotlin.math.abs

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    var answer= abs(num-100)
    val brokeCount = readLine().toInt()
    val unbrokenNums = ArrayList<Int>()
    for(i in 0 .. 9){
        unbrokenNums.add(i)
    }
    if(brokeCount!=0){
        val brokeNums = readLine().split(" ").map { it.toInt() }.toIntArray()
        for(i in 0 .. 9){
            if(brokeNums.contains(i))
                unbrokenNums.remove(i)
        }
    }

    for(i in 0 .. 999999){
        if(answer==0)
            break

        if(!isPossible(i,unbrokenNums))
            continue

        var temp = abs(i-num) + i.toString().length
        answer = minOf(temp,answer)
    }

    println(answer)
}
fun isPossible(num:Int,unbrokenNums:ArrayList<Int>):Boolean{
    val numArray = num.toString().map { it.toString().toInt() }
    for(temp in numArray){
        if(!unbrokenNums.contains(temp)){
            return false
        }
    }
    return true
}
