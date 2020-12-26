import java.io.File

fun main() {
    val input =
        //"AoC13.test"
        "AoC13.txt"
    var lines = File(input)
        .readLines()
    val early = lines[0].toLong()
    val parts = lines[1].split(",")
    var busesA = mutableListOf<Long>()
    var index  = mutableListOf<Int>()
    var buses = mutableMapOf<Long, Long>()
    var inde = 0
        for (p in parts) {
            try {
                val b = p.toLong()
                busesA.add(b)
                index.add(inde)
                buses[inde.toLong()] = b
            } catch(e : Exception) { }
            inde++
        }
    var i = 1
    lab@
    while (true) {
        for(j in 0 until busesA.count()) {
            if (busesA[j] * i >= early) {
                println("A: ${busesA[j]*(busesA[j] * i - early)} ")
                break@lab
            }
        }
        i++
    }
    //19,x,x,x,x,x,x,x,x,41,x,x,x,37,x,x,x,x,x,367,x,x,x,x,x,x,x,x,x,x,x,x,13,x,x,x,17,x,x,x,x,x,x,x,x,x,x,x,29,x,373,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,23
//    println(busesA)
//    println(index)
    var time = 0L
    var product = 1L
    for ((offset, bnumber) in buses) {
        while ((time + offset) % bnumber != 0L)
                time += product
        product *= bnumber
    }
    println("B: $time")
    //println("product:$product")
}
