class Solution {
    val set = mutableSetOf<Int>()
    fun solution(numbers: String): Int {
        var answer = 0
        Combination(numbers,"")
        return set.filter { isPrime(it) }.count()
    }
    fun Combination(numbers:String,result:String){
        if(result.isNotEmpty()) set.add(result.toInt())
        if(numbers.isEmpty())   return
        numbers.forEachIndexed { index,c ->
            Combination(numbers.removeRange(index..index),c.plus(result))
        }
    }
    fun isPrime(num:Int):Boolean{
        if(num==0||num==1)
            return false
        for (i in 2..num/2){
            if(num%i==0){
                return false
            }
        }
        return true
    }
}