import java.io.File

fun allPosib(n : Int, adr : Long, v : Long,
             memory: MutableMap<Long, Long>,
             mz : Set<Int>
            ) {
    if (n > 35)
        memory[adr] = v
    else {
        if (mz.contains(35-n)) {
            val nbit = 1L shl n
            val nadr = nbit.inv() and adr
            allPosib(n+1, nadr, v, memory, mz)
            allPosib(n+1, nadr or nbit, v, memory, mz)
        } else {
            allPosib(n+1, adr, v, memory, mz)
        }
    }
}

fun main() {
    val input =
        //"AoC14.test"
        "AoC14.txt"
    var mask = ""
    var memory = mutableMapOf<Int, Long>()
    var lines = File(input)
        .readLines()
        .map {it.replace("[", " ")}
        .map {it.replace("]", " ")}
    for (l in lines) {
        if (l.startsWith("mem")) {
            val parts = l.split(" ")
            //println(parts)
            val adr = parts[1].toInt()
            var value = parts[4].toLong()
            var bit = 0
            var result = 0L
            while (bit < mask.length) {
                if (value % 2 == 0L) {
                    if (mask.reversed()[bit] == 'X' || mask.reversed()[bit] == '0')
                        result = result
                    else if (mask.reversed()[bit] == '1')
                        result = result or (1L shl bit)
                } else {
                    if (mask.reversed()[bit] == '0')
                        result = result
                    else if (mask.reversed()[bit] == '1' || mask.reversed()[bit] == 'X' )
                        result = result or (1L shl bit)
                }
                value = value/2L
                bit++
            }
            memory[adr] = result
        } else if (l.startsWith("mask"))
            mask = l.split(" ")[2]
    }
    println("A: ${memory.values.sum()}")
    //-------------------
    var adrMask = 0L
    var mz = mutableSetOf<Int>()
    var memory2 = mutableMapOf<Long, Long>()
    for (l in lines) {
        if (l.startsWith("mem")) {
            val parts = l.split(" ")
            var adr = parts[1].toLong()
            var value = parts[4].toLong()
            allPosib(0, adr or adrMask, value, memory2, mz)
        } else {
            val parts = l.split(" ")
            val lmask = parts[2]
            adrMask = 0
            mz = mutableSetOf<Int>()
            for((i,ch) in lmask.withIndex()) {
                adrMask = 2*adrMask
                if (ch == '1')
                    adrMask++
                else if (ch == 'X')
                    mz.add(i)
            }
        }
    }
    println("B: ${memory2.values.sum()}")
}
