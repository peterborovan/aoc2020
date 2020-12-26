import java.io.File
import java.util.*

fun main() {
    val input = //"AoC05.test"
                 "AoC05.txt"
    val lines = File("AoC05.txt")
        .readLines()
        .map { Integer.parseInt(it
                 .replace("(F|L)".toRegex(), "0")
                 .replace("(B|R)".toRegex(), "1"),2) }
    println("A: ${lines.max()}")
    (0..1000).forEach() {
        if (lines.contains(it-1) && lines.contains(it+1) && !lines.contains(it))
            println("B: $it")
    }
}