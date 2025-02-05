var nums = intArrayOf(1,1,1,1,1,1,1,1,1,1)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    repeat(N-1){
        for(i in 1..9){
            nums[i] = (nums[i-1]+nums[i])%10007
        }
    }
    val result = nums.sum()%10007
    println(result)
}