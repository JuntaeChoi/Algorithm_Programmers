
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   val needNum = IntArray(9){0}
   val roomNum = readLine().map { it.toString().toInt() }
   for(num in roomNum){
      if(num==9){
         needNum[6]++
      }else{
         needNum[num]++
      }
   }
   needNum[6]=(needNum[6]+1)/2
   println(needNum.max())
}
