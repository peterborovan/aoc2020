import java.io.File
var player1 = mutableListOf(
    41,
    33,
    20,
    32,
    7,
    45,
    2,
    12,
    14,
    29,
    49,
    37,
    6,
    11,
    39,
    46,
    47,
    38,
    23,
    22,
    28,
    10,
    36,
    35,
    24
)
var player1B = player1.toMutableList()
var player2 = mutableListOf(
    17,
    4,
    44,
    9,
    27,
    18,
    30,
    42,
    21,
    26,
    16,
    48,
    8,
    15,
    34,
    50,
    19,
    43,
    25,
    1,
    13,
    31,
    3,
    5,
    40
)
var player2B = player2.toMutableList()

//var player1 = mutableListOf(
//9,
//2,
//6,
//3,
//1)
//
//var player2 = mutableListOf(
//5,
//8,
//4,
//7,
//10
//)

fun subgame(recursive : Boolean,
            lev : Int,
            player1 : MutableList<Int>,
            player2 : MutableList<Int>):Boolean {
    var visited = mutableListOf<Pair<MutableList<Int>,MutableList<Int>>>()
        while (player1.count() > 0 && player2.count() > 0) {
            //println(was.count())
            if (visited.contains(Pair(player1, player2)))
                return true
            else {
                val player1copy = player1.toList().toMutableList()
                val player2copy = player2.toList().toMutableList()
                visited.add(Pair(player1copy, player2copy))
                val top1 = player1[0]
                val top2 = player2[0]
                player1.removeAt(0)
                player2.removeAt(0)
                if (recursive &&
                    top1 <= player1.count() && top2 <= player2.count()) {
                    var pp1 = mutableListOf<Int>()
                    var pp2 = mutableListOf<Int>()
                    for (i in 0 until top1)
                        pp1.add(player1[i])
                    for (i in 0 until top2)
                        pp2.add(player2[i])
                    //println("subgame $pp1 $pp2")
                    val res = subgame(recursive, lev + 1, pp1, pp2)
                    if (res) {
                        player1.add(top1)
                        player1.add(top2)
                    } else {
                        player2.add(top2)
                        player2.add(top1)
                    }
                } else if (top1 > top2) {
                    player1.add(top1)
                    player1.add(top2)
                } else if (top2 > top1) {
                    player2.add(top2)
                    player2.add(top1)
                }
            }
        }
        if (player1.count() == 0) return false
        if (player2.count() == 0) return true
        return false
}
fun main() {
    val sf = ".txt"
    //val sf = ".test"
    val lines = File("AoC22"+sf)
        .readLines()
    var res = subgame(false, 0, player1, player2)
    var p = mutableListOf<Int>()
    p.addAll(player1.reversed())
    p.addAll(player2.reversed())
    var sum = 0L
    for ((i,e) in p.withIndex()) sum += e*(1+i)
    println("A: $sum")
    //--
    res = subgame(true, 0, player1B, player2B)
    p = mutableListOf<Int>()
    p.addAll(player1B.reversed())
    p.addAll(player2B.reversed())
    sum = 0L
    for ((i,e) in p.withIndex()) sum += e*(1+i)
    println("B: $sum")
}
