import java.io.File
import java.util.*

fun main() {
    val input = //"AoC02.test"
                 "AoC02.txt"
    val lines = File(input)
        .readLines()
        .map { it.split(" |-|:".toRegex())
            .filter {it.isNotEmpty()}
            .map { it.trim()} }
    println("A:${
        lines.count {line ->
            var vyskyt = line[3].count { it == line[2][0] }
            (vyskyt >= line[0].toInt() && vyskyt <= line[1].toInt())

        }}")
    println("B:${lines.count { line ->
        var vyskyt = 0
        for((index,x) in line[3].withIndex()) {
            if (line[2][0] == x && (index+1 == line[0].toInt() || index+1 == line[1].toInt()))
                vyskyt++
        }
        (vyskyt == 1)
    }}")
}