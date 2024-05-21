import java.util.*

private data class Edge(val to:Int,val distance:Int)
private data class Node(val vertex:Int, val distance:Int):Comparable<Node>{
    override fun compareTo(other: Node): Int = this.distance-other.distance
}
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val line = readLine().split(" ")
    val v = line[0].toInt()
    val e = line[1].toInt()
    val start = readLine().toInt()-1
    val graph = List(v){ mutableListOf<Edge>() }
    repeat(e){
        val nums = readLine().split(" ").map { it.toInt() }
        graph[nums[0]-1].add(Edge(nums[1]-1,nums[2]))
    }
    val distances = dijkstra(start,graph)
    for(i in 0 until v){
        if(distances[i]==Int.MAX_VALUE)
            println("INF")
        else
            println(distances[i])
    }
}

private fun dijkstra(start:Int, graph:List<List<Edge>>):IntArray{
    val n = graph.size
    val distance = IntArray(n){Int.MAX_VALUE}
    val queue = PriorityQueue<Node>()
    distance[start]=0
    queue.add(Node(start,0))
    while(queue.isNotEmpty()){
        val current = queue.poll()
        if(current.distance>distance[current.vertex]) continue
        for(edge in graph[current.vertex]){
            val newDistance = current.distance+edge.distance
            if(newDistance<distance[edge.to]){
                distance[edge.to]=newDistance
                queue.add(Node(edge.to,newDistance))
            }
        }
    }
    return distance
}


