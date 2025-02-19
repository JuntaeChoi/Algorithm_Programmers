import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val stack = Stack<String>()
    val list = readLine().map { it.toString() }
    var total = 0
    var isLaser = true

    for (item in list) {
        if (item.equals("(")) {
            stack.push("(")
            isLaser = true
        } else {
            stack.pop()
            if (isLaser) {
                total += stack.size
                isLaser = false
            } else {
                total += 1
            }
        }
    }
    println(total)
}