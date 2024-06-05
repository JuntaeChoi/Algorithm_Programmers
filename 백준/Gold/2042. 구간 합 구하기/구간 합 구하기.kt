lateinit var tree :Array<Long>
lateinit var arr:Array<Long>

fun main(args: Array<String>)= with(System.`in`.bufferedReader()) {
    val (n,m,k) = readLine().split(" ").map { it.toInt() }
    arr = Array(n+1){if(it==0)0L else readLine().toLong()}
    tree = Array(n*4+1){0L}
    init(1,n,1)

    repeat(m+k){
        val input=readLine().split(" ")
        val a = input[0].toInt()
        val b = input[1].toInt()
        val c = input[2].toLong()
        if(a==1){
            val diff = c-arr[b]
            arr[b] = c // arr 배열의 값을 업데이트
            update(1,n,1,b,diff)
        }
        else if(a==2){
            println(sum(1,n,1,b,c.toInt()))
        }
    }
}

fun init(start:Int,end:Int,node:Int):Long{
    if(start==end){
        tree[node]=arr[start]
        return tree[node]
    }
    val mid = (start+end)/2
    tree[node]=init(start,mid,node*2)+init(mid+1,end,node*2+1)
    return tree[node]
}
fun sum(start:Int,end:Int,node:Int,left:Int,right:Int):Long{
    if(end<left||start>right)
        return 0
    else if(left<=start&&end<=right)
        return tree[node]

    val mid = (start+end)/2
    return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right)
}

fun update(start:Int,end:Int,node:Int,index:Int,diff:Long){
    if(index !in start..end)
        return
    tree[node]+=diff
    if(start==end)
        return
    val mid = (start+end)/2
    update(start,mid,node*2,index,diff)
    update(mid+1,end,node*2+1,index,diff)
}