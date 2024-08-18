import java.lang.StringBuilder

val sb = StringBuilder()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arrayList = ArrayList<Int>()
    backTracking(n, m, arrayList)
    println(sb)
}

fun backTracking(n: Int, m: Int, arrayList: ArrayList<Int>) {
    if (arrayList.size == m) {
        sb.append(arrayList.joinToString(" "))
        sb.append("\n")
        return
    }

    for (i in 1..n) {
        arrayList.add(i)
        backTracking(n, m, arrayList)
        arrayList.removeAt(arrayList.size - 1)
    }
}