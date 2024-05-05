class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var wid =0
        var hei =0
        for(i in sizes){
            wid = Integer.max(wid,i.sorted()[0])
            hei = Integer.max(hei,i.sorted()[1])
        }
        return wid*hei
    }
}