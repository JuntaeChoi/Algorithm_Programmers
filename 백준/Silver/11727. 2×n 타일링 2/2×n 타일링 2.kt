
fun main(args: Array<String>)= with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val arr = LongArray(n+1)
    if(n==1)
        println("1")
    else if(n==2)
        println("3")
    else{
        arr[1]=1
        arr[2]=3
        for(i in 3..n){
            if(i%2==1)
                arr[i]=(arr[i-1]*2-1)%10007
            else
                arr[i]=(arr[i-1]*2+1)%10007
        }
        println(arr[n])
    }
}