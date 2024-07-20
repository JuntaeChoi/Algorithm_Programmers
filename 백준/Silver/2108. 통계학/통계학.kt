import kotlin.math.roundToInt

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   val n = readLine().toInt()
   val arr = IntArray(n){readLine().toInt()}

   println(getAverage(n,arr))
   println(getMedian(n,arr))
   println(getMode(n,arr))
   println(getRange(n,arr))
}

fun getAverage(n:Int, arr : IntArray):Int{
   return (arr.sum().toFloat()/n).roundToInt()
}

fun getMedian(n:Int, arr : IntArray):Int{
   return arr.sorted()[n/2]
}

fun getMode(n:Int, arr : IntArray):Int{
   val map = mutableMapOf<Int,Int>()
   for(i in arr){
      map[i]=map.getOrDefault(i,0)+1
   }
   val list = mutableListOf<Int>()
   var frequency = 0
   for(i in map){
      if(i.value>frequency){
         list.clear()
         list.add(i.key)
         frequency = i.value
      }else if(i.value==frequency)
         list.add(i.key)
   }
   return if(list.size==1) list[0] else list.sorted()[1]
}

fun getRange(n:Int, arr : IntArray):Int{
   return arr.max()-arr.min()
}