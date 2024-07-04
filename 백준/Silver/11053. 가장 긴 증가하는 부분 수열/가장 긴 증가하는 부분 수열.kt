//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val nums = readLine().split(" ").map { it.toInt() }
    val array = Array(n+1){1}

    for(i in 1 until n){
        for(j in 0 until i){
            if(nums[j]<nums[i])
                array[i]= maxOf(array[i],array[j]+1)
        }
    }
    println(array.max())
}