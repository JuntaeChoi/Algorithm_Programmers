fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val arrayList = ArrayList<Int>()
    backTracking(n,m,arrayList)
}
fun backTracking(n:Int,m:Int,arrayList:ArrayList<Int>){
    if(arrayList.size==m){
        println(arrayList.joinToString(" "))
        return
    }

    for(i in 1 .. n){
        if(arrayList.isEmpty()){
            addAndRemove(n,m,i,arrayList)
        }else if(arrayList.last()<=i){
            addAndRemove(n,m,i,arrayList)
        }
    }
}

fun addAndRemove(n:Int,m:Int,i:Int,arrayList: ArrayList<Int>){
    arrayList.add(i)
    backTracking(n,m,arrayList)
    arrayList.remove(i)
}