fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val xHash = hashMapOf<Int,Int>()
    val yHash = hashMapOf<Int,Int>()

    repeat(3){
        var dot = readLine().split(" ").map{ it.toInt() }
        if(xHash.containsKey(dot[0])){
            xHash.replace(dot[0], xHash[dot[0]]!!+1)
        }else{
            xHash.putIfAbsent(dot[0],1)
        }
        if(yHash.containsKey(dot[1])){
            yHash.replace(dot[1], yHash[dot[1]]!!+1)
        }else{
            yHash.putIfAbsent(dot[1],1)
        }
    }
    val x = xHash.filterValues { it==1 }.keys.first().toString()
    val y = yHash.filterValues { it==1 }.keys.first().toString()

    println("$x $y")
}