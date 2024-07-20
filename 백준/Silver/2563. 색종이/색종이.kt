fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   val n = readLine().toInt()
   val arr = Array(100){BooleanArray(100){false} }
   repeat(n){
      val (x,y) = readLine().split(" ").map { it.toInt() }
      for(i in x until x+10){
         for(j in y until y+10){
            if(i in 0 until 100 && j in 0 until 100)
               arr[i][j] = true
         }
      }
   }
   var temp = 0
   arr.forEach { it.forEach { if(it) temp++  } }
   println(temp)
}