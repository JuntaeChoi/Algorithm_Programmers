import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stack = Stack<Int>()
    val str = StringBuilder()
    var count = 1
    for(i in 1..n){
        val now = readLine().toInt()
        if(count<=now){
            for(j in count .. now){
                stack.add(count++)
                str.append("+\n")
            }
            stack.pop()
            str.append("-\n")
        }else if(stack.isNotEmpty()&&now==stack.peek()){
            stack.pop()
            str.append("-\n")
        }else{
            str.clear()
            str.append("NO\n")
            break
        }
    }
    print(str)
}
