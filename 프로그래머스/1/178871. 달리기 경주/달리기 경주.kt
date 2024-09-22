
class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val rankMap = mutableMapOf<String, Int>()
        players.forEachIndexed{ index, s ->
            rankMap[s] = index
        }
        callings.forEach{
            val callRank = rankMap[it] ?: 0
            val frontPlayer = players[callRank-1]
            
            players[callRank-1] = it
            players[callRank] = frontPlayer
            
            rankMap[it] = callRank - 1
            rankMap[frontPlayer] = callRank
        }
        
        return players
    }
}