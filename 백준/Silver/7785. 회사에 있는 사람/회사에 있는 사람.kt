import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val set = mutableSetOf<String>()
    for(i in 1..n){
        val line = readLine().split(" ")
        val name = line[0]
        val did = line[1]
        if(did=="enter")
            set.add(name)
        else if(did=="leave")
            set.remove(name)
    }
    for(i in set.sortedDescending()){
        println(i)
    }

}