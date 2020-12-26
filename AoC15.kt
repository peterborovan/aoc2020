import java.io.File

fun main() {
    val input =
        //"AoC15.test"
        "AoC15.txt"
    var lines = File(input)
        .readLines()
    var inp = lines[0].split(",")
                .map {it.toInt() }
                .toMutableList()
    var lastTimeA = mutableMapOf<Int, Int>()
    var lastTime = mutableMapOf<Int, MutableList<Int>>()
    var spoken = mutableListOf<Int>()
    var index = 0
    for(x in inp) {
        spoken.add(x)
        lastTimeA[x] = index
        lastTime[x] = listOf(index).toMutableList()
        index++
    }

    val leng = 2020
    while (inp.count() < leng) {
        val last = inp.last()
        var j = lastTimeA[last]!!.toInt()-1
        while(j >= 0) {
            if (inp[j] == last) {
                break
            }
            j--
        }
        if (j!=-1) {
            //println("next time $last")
            val n = (lastTimeA[last]!!-j)
            lastTimeA[n] = inp.count()
            inp.add(n)
        } else {
            //println("first time $last")
            lastTimeA[0] = inp.count()
            inp.add(0)
        }
    }
    println("A: ${inp[leng-1]}")
    //--------
    inp = lines[0].split(",")
        .map {it.toInt() }
        .toMutableList()

    val len = 30000000
    var l = 0
    while (inp.count() < len) {
        if (l % 1000 == 0) {
            println(l/1000)
        }
        l++
        val last = inp.last()
        if (lastTime[last]!!.count() > 1) {
            //println("next time $last")
            val n = (lastTime[last]!![0] - lastTime[last]!![1])
            if (lastTime[n] == null) {
                lastTime[n] = listOf(inp.count()).toMutableList()
            } else {
                lastTime[n]!!.add(0, inp.count())
            }
            inp.add(n)
        } else {
            lastTime[0]!!.add(0, inp.count())
            inp.add(0)
        }
    }
    // hodne pitome riesenie, ale hruba sila...
    println("B: ${inp[len-1]}")
}
