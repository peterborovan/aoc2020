import java.io.File
import java.util.*

fun main() {
    val input = //"AoC06.test"
     "AoC06.txt"

    var sc = Scanner(File(input))
    var lines = mutableListOf<MutableList<String>>()
    var oneGroup = mutableListOf<String>()
    while (sc.hasNextLine()) {
        val line = sc.nextLine()
        if (line.trim().length == 0) {
            lines.add(oneGroup)
            oneGroup = mutableListOf<String>()
            continue
        }
        oneGroup.add(line)
    }
    lines.add(oneGroup)
    var sum = 0
    for (l in lines) {
        val s = mutableSetOf<Char>()
        l.forEach { s.addAll(it.toSet()) }
        sum += s.count()
    }
    println("A: $sum")
    var sumB = 0
    for (l in lines) {
        var s = "abcdefghijklmnpoqrstuvwxyz".toSet()
        l.forEach { s = s intersect (it.toSet()) }
        sumB += s.count()
    }
    println("B: $sumB")
}
