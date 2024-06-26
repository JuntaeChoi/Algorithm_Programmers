fun main(args: Array<String>)= with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n){
        val words = readLine().split(" ")
        for(word in words){
            reverseString(word,sb)
        }
        sb.append("\n")
    }
    println(sb)
}
fun reverseString(word:String,sb:StringBuilder){
    for(i in word.length-1 downTo 0){
        sb.append(word[i])
    }
    sb.append(" ")
}