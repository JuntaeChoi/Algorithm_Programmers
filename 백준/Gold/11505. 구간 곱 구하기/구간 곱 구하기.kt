lateinit var mulTree :Array<Long>
lateinit var arr:Array<Long>
const val MOD = 1000000007

fun main(args: Array<String>)= with(System.`in`.bufferedReader()) {
    val (n,m,k)=readLine().split(" ").map { it.toInt() }
    arr = Array(n+1){if(it==0)0L else readLine().toLong()}
    mulTree = Array(4*n+1){1L}
    init(1,n,1)
    repeat(m+k){
        val (a,b,c)=readLine().split(" ").map { it.toInt() }
        if(a==1){
            arr[b]=c.toLong()
            update(1,n,1,b,c.toLong())
        }
        else{
            println(findMul(1,n,1,b,c))
        }
    }
}

fun init(start:Int,end:Int,node:Int):Long{
    if(start==end){
        mulTree[node]=arr[start]
        return mulTree[node]
    }
    val mid = (start+end)/2
    mulTree[node] = (init(start,mid,node*2)*init(mid+1,end,node*2+1))%MOD
    return mulTree[node]
}
fun findMul(start:Int,end:Int,node:Int,left:Int,right:Int):Long{
    if(end<left||start>right)
        return 1L
    if(left<=start&&right>=end)
        return mulTree[node]
    val mid=(start+end)/2
    return (findMul(start,mid,node*2,left,right)*findMul(mid+1,end,node*2+1,left,right))%MOD
}
fun update(start:Int,end:Int,node:Int,index:Int,newValue:Long):Long{
    if(index <start || index>end)
        return mulTree[node]
    if(start==end){
        arr[index]=newValue
        mulTree[node]=newValue
        return mulTree[node]
    }
    val mid = (start+end)/2
    mulTree[node]=(update(start,mid,node*2,index,newValue) *update(mid+1,end,node*2+1,index,newValue))%MOD
    return mulTree[node]
}