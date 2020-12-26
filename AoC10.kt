import java.io.File

var results = mutableMapOf<Int, Long>()

fun reka(act : Int, s : MutableSet<Int>, finish : Int) : Long {
    if (results[act] != null) {
        return results[act]!!
    } else {
        var sum = 0L
        if (act+1 == finish)
            sum++
        else if (s.contains(act+1))
            sum += reka(act+1, s, finish)
        if (act+2 == finish)
            sum++
        else if (s.contains(act+2))
            sum += reka(act+2, s, finish)
        if (act+3 == finish)
            sum++
        else if (s.contains(act+3))
            sum += reka(act+3, s, finish)
        results[act] = sum
        return sum
    }
}

fun main() {
    val input =
        //"AoC10.test"
        "AoC10.txt"
    val lines = File(input)
        .readLines()
        .map{ it.toInt()}
    var x = lines.toSet().toMutableList()
   // println(x.sorted())
    var m = x.min()!!
    x.remove(m)
    var c1 = 0
    var c3 = 0
    while (x.count() > 0) {
        val y = x.min()!!
        if (y == m+1)
            c1++
        if (y == m+3)
            c3++
        m = y
        x.remove(y)
    }
    //println("${c1+1}, ${c3+1}")
    println("A: ${(c1+1) * (c3+1)}")
    var xx = lines.toSet().toMutableSet()
    val b = reka(0, xx, xx.max()!!+3)
    println("B: $b")
}
